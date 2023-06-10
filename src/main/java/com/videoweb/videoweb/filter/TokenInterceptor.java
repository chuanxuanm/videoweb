package com.videoweb.videoweb.filter;

import com.alibaba.druid.util.StringUtils;
import com.videoweb.videoweb.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class TokenInterceptor implements HandlerInterceptor {


    private TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        if ("OPTIONS".equals(request.getMethod())) {
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, token");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setStatus(HttpServletResponse.SC_OK);

            return false;
        }
        if ("/users/checkUserExist".equals(requestURI) || "/users/registerUser".equals(requestURI)||"/ChangeInfo/Test".equals(requestURI)) {
            return true;
        }
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            System.out.println("Token is enpty");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Token is enpty");
            return false;
        }
        tokenService=new TokenService();
        TokenService.TokenInfo tokenInfo = tokenService.parseToken(request.getHeader("token"));
        if (tokenInfo == null) {
            System.out.println("Invalid token");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid token");
            return false;
        }

        if (tokenService.isTokenExpired(tokenInfo)) {
            System.out.println("Token is expired");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Token is expired");
            return false;
        }
        System.out.println("离开");

        return true;
    }
}
