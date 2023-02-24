package com.group42.security;

import com.group42.constant.ErrorEnum;
import com.group42.model.bean.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        log.info("JwtAccessDeniedHandler:{}", accessDeniedException.getMessage());
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setStatus(HttpStatus.OK.value());
        PrintWriter out = response.getWriter();
        out.write(new R(ErrorEnum.NOT_FOUND).toString());
    }

}
