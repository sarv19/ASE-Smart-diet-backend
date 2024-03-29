package com.group42.security.filter;

import com.group42.constant.Constants;
import com.group42.model.entity.User;
import com.group42.service.IUserService;
import com.group42.utils.JwtUtils;
import com.group42.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    private final IUserService userService;
    private final UserDetailsService JwtUserDetailsService;


    public JwtAuthorizationTokenFilter(IUserService userService, UserDetailsService JwtUserDetailsService) {
        this.userService = userService;
        this.JwtUserDetailsService = JwtUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = request.getRequestURI();
        // Bypass path means that the path does not need to be validated
        boolean needValidate = !StringUtils.contains(uri, Constants.BYPASS_PATHS, true);

        User user = null;
        if (needValidate) {
            user = userService.findUserByUid(JwtUtils.getUserUid(request));
        }
        log.info("=====request URI: " + uri + " ; User: " + user);
        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // begin authentication
            UserDetails userDetails = JwtUserDetailsService.loadUserByUsername(user.getUserName());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
