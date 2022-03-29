package com.QiBaochao.week5.homework;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException{
        super.init();
        try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),
                    getServletConfig().getServletContext().getInitParameter("Username"),
                    getServletConfig().getServletContext().getInitParameter("Password"));
        } catch (Exception e) {
            System.out.println(e); }
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(username + password);
        PrintWriter writer = response.getWriter();
        try {
            if( con != null){
                String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    writer.println("Login Success!!!");
                    writer.println("Welcome "+username+".");
                }else{
                    writer.print("Username or Password Error!!!");
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("message","Username Or Password Error!!");
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
