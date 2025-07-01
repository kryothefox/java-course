/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.planify.web;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class authFilter implements Filter {

    private List<String> excludeURL = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        String excluseURLString = filterConfig.getInitParameter("excludeURL");
        if (excluseURLString != null) {
            excludeURL = Arrays.asList(excluseURLString.split(","));

        }

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        String baseURI = req.getContextPath() + "/login.jsp";

        String endpointURI = req.getRequestURI().substring(req.getContextPath().length());

        boolean isSafeURI = excludeURL.stream().anyMatch(endpointURI::startsWith);
        boolean isLogged = (session != null && session.getAttribute("user") != null);

        if (isSafeURI || isLogged) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(baseURI);
        }
    }

}
