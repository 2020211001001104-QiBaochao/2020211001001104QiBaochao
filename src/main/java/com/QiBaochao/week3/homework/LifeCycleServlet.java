package com.QiBaochao.week3.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {
    Connection con=null;
    public LifeCycleServlet(){
        System.out.println("i am in constructor --> LifeCycleServlet()");
    }
    @Override
    public void init(){

        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection -->"+con);//just print for test
        } catch (ClassNotFoundException|SQLException  e) {
            e.printStackTrace();
        }
        System.out.println("i am an init()->LifeCycleServlet-->"+con);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service --> doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy(){
        System.out.println("i am in destroy()");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}