package com.QiBaochao.lab2;

import javax.servlet.*;
import java.io.IOException;

public class QiBaochaoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("QiBaochaoFilter--->before chain");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("QiBaochaoFilter--->after chain");
    }

    @Override
    public void destroy() {

    }
}