package com.group42.security.filter;

import com.group42.constant.Constants;
import com.group42.model.entity.User;
import com.group42.service.IUserService;
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

    //    private final JwtTokenUtil jwtTokenUtil;


    public JwtAuthorizationTokenFilter(IUserService userService,UserDetailsService JwtUserDetailsService) {
//        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.JwtUserDetailsService = JwtUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        final String requestHeader = request.getHeader(this.tokenHeader);
        String uri = request.getRequestURI();

        log.info("=====request URI: " + uri);
        // Bypass path means that the path does not need to be validated
        boolean needValidate = !StringUtils.contains(uri, Constants.BYPASS_PATHS, true);

        User user = null;
        if (needValidate) {
            user = userService.validateUser("123","123");
        }

        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = JwtUserDetailsService.loadUserByUsername(user.getUserName());

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
//        try {
//            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
//            String inputStr;
//            while ((inputStr = streamReader.readLine()) != null)
//                System.out.println(inputStr);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        chain.doFilter(request, response);
    }
}
