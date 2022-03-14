package com.QiBaochao.week3.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("I am in constructor --> LifeCycleServlet().");
    }

    public void init(){

        System.out.println("I am in init().");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in doGet() --> doGet().");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public  void  destroy(){
        System.out.println("I am in destroy().");
    }
}