package com.QiBaochao.week3.homework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class RegisterServlet extends HttpServlet {
    Connection con=null;//class variable
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in Register "+con);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
//        writer.println("<br>username :"+username);
//        writer.println("<br>password :"+password);
//        writer.println("<br>email :"+email);
//        writer.println("<br>gender :"+gender);
//        writer.println("<br>birth Date :"+birthDate);
//        writer.close();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");


        String sql="insert into usertable values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,birthdate);
            preparedStatement.execute();

            PrintWriter out=response.getWriter();
            sql="select * from usertable";
            preparedStatement=con.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            out.println("<html><body>");
            out.println("<table border='2'>");
            out.println("<tr><th>ID</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthdate</th></tr>");
            out.println("<tr><th>"+1+"</th><th>"+username+"</th><th>"+password+"</th><th>"+email+"</th><th>"+gender+"</th><th>"+birthdate+"</th></tr>");
            out.println("</table>");
            out.println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}