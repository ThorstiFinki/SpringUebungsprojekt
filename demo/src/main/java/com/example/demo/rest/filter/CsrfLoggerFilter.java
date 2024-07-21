package com.example.demo.rest.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/* Das Token wird in bruno in den Header Daten bei Get Anfrage gezeigt
und muss dann mit dem Session Cookie bei der Post ANfrage angegeben werden.
 */

public class CsrfLoggerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");

        response.setHeader("SCRF-TOKEN-VALUE", csrfToken.getToken());
        System.out.println(csrfToken.getToken());

        filterChain.doFilter(request,response);
    }
}
