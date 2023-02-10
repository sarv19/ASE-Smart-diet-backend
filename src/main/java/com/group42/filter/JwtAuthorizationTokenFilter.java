//package com.group42.filter;
//
//import com.mtrsz.common.constant.Constants;
//import com.mtrsz.common.constant.RedisKey;
//import com.mtrsz.common.constant.SessionConsts;
//import com.mtrsz.common.core.redis.RedisCache;
//import com.mtrsz.common.excpetion.UtilException;
//import com.mtrsz.common.security.JwtTokenUtil;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private RedisCache redisUtil;
//
//	@Value("${jwt.expiration:2592000}")
//	private int loginTimeout;
//
//	private final UserDetailsService userDetailsService;
//	private final JwtTokenUtil jwtTokenUtil;
//	private final String tokenHeader;
//
//
//	public JwtAuthorizationTokenFilter(@Qualifier("jwtUserDetailsService") UserDetailsService userDetailsService,
//									   JwtTokenUtil jwtTokenUtil, @Value("${jwt.token}") String tokenHeader) {
//		this.userDetailsService = userDetailsService;
//		this.jwtTokenUtil = jwtTokenUtil;
//		this.tokenHeader = tokenHeader;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//		final String  requestHeader = request.getHeader(this.tokenHeader);
//
//		String uri = request.getRequestURI();
//
//		log.info("=====前端请求地址URI:"+uri);
//		boolean isValidate = true;
//		for(String s : Constants.NO_VALIDATE_TOKEN ) {
//			if(uri.contains(s)) {
//				isValidate = false;
//				break;
//			}
//		}
//		String username = null;
//		String authToken = null;
//		if (requestHeader != null && requestHeader.startsWith(SessionConsts.TOKEN_PREFIX) && isValidate) {
//			authToken = requestHeader.substring(7);
//			//检查Redis中是否已过期
//			Object oldTokenUser = redisUtil.getCache(RedisKey.getTokenUserInfo(authToken));
//
//			if(oldTokenUser == null) {
//				throw new UtilException("用户信息已过期");
//			}
//
//			try {
//				username = jwtTokenUtil.getUsernameFromToken(authToken);
//			} catch (ExpiredJwtException e) {
//				logger.info("Token expired: {}" , e);
//			}
//		}
//
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//
//			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			}
//			//更新过期时间
//			redisUtil.expire(RedisKey.getTokenUserInfo(authToken), loginTimeout);
//			redisUtil.expire(RedisKey.getLoginToken(username), loginTimeout);
//
//		}
//		chain.doFilter(request, response);
//	}
//}
