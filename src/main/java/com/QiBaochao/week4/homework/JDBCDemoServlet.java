package com.QiBaochao.week4.homework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)//only url and load on startup
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;//class variable
    @Override
    public void init() throws ServletException {
        super.init();

        //demo #3 - use Servletcontext
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        //now use 4 variables to get connection
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet "+con);//just print for test

            //one connection
        } catch (ClassNotFoundException|SQLException  e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        //close connection here - when stop tomcat
    }
}
