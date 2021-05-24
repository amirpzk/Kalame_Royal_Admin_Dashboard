package com.Prana.KalameRoyal.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter extends OncePerRequestFilter {

    // TODO: 1/9/2019 Show this class to ramon

//    protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
//    protected static final String RESPONSE_TOKEN_NAME = "XSRF-TOKEN";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token, token");
        response.addHeader("Access-Control-Expose-Headers", "xsrf-token, authorization, token");

//        CsrfToken csrf = (CsrfToken) request.getAttribute(REQUEST_ATTRIBUTE_NAME);
//        if (csrf != null) {
//            Cookie cookie = new Cookie(RESPONSE_TOKEN_NAME, csrf.getToken());
//            cookie.setPath("/");
//            response.addCookie(cookie);
//        }

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }


}