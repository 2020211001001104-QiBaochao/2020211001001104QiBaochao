package com.QiBaochao.week3.homework;

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
//now use
@WebServlet("/life")//only url - no web.xml code
public class LifeCycleServlet extends HttpServlet {
    //1.tomcat read wen.xml file and find out all servlet class
    //2.load servlet - when ?2.first request for this servlet come in - from client
    //3.call default constructor - add code
    Connection con = null;
    public  LifeCycleServlet(){
        System.out.println("I am in constructor --> LifeCycleServlet() ");//line 1
    }
    //4.init() - add code
    public void init(){
        //we can use in many Servlet
        //demo #3 - use Servletcontext
        ServletContext context =getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");


        //now use 4 variables to get connection
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);//just print for test

            //one connection -
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("c "+con);//line 2
    }

    //5.tomcat call  service(）--》 call doGet() or doPost()
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in service() --> doGet()   ");//line 3
        //line 4 - 2nd request
        //line 5 - 3rd request
        //and so on -- many times - for each request
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {



        System.out.println("I am in destroy()  ");//when ?- stop tomcat
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}