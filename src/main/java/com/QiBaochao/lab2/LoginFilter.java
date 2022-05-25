package com.QiBaochao.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns ="/lab2/welcome.jsp")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("I am in LoginFilter--init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("I am in LoginFilter--doFilter()()--request before chain");
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        if(request.getSession()!=null&&request.getSession().isNew()){
            request.getRequestDispatcher("/lab2/welcome.jsp").forward(servletRequest, servletResponse);
        }else {
            response.sendRedirect(request.getContextPath()+"/lab2/login.jsp");
        }
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("I am in LoginFilter--destroy()--response after chain");

    }

    @Override
    public void destroy() {
        System.out.println("I am in LoginFilter--destroy()");
    }
}