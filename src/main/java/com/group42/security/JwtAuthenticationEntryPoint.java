package com.group42.security;

import com.group42.constant.ErrorEnum;
import com.group42.model.bean.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException {

        log.info("JwtAuthenticationEntryPoint:{}", authException.getMessage());
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setStatus(HttpStatus.OK.value());
        PrintWriter out = response.getWriter();
        out.write(new R(ErrorEnum.NEED_AUTHORIZATION).toString());
    }
}
