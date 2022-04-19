package com.QiBaochao.week5.homework;

import com.QiBaochao.dao.UserDao;
import com.QiBaochao.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException{
        super.init();
        /*try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),
                    getServletConfig().getServletContext().getInitParameter("Username"),
                    getServletConfig().getServletContext().getInitParameter("Password"));
        } catch (Exception e) {
            System.out.println(e); }*/
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(username + password);
        PrintWriter writer = response.getWriter();
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {
                String rememberMe = request.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie =new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie =new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie =new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(100);
                    passwordCookie.setMaxAge(100);
                    rememberMeCookie.setMaxAge(100);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session = request.getSession();
                System.out.println("session id is "+ session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*
        try {
            if( con != null){
                String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    writer.println("Login Success!!!");
                    writer.println("Welcome "+name+".");
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("username",rs.getString(1));
                    request.setAttribute("password",rs.getString(2));
                    request.setAttribute("email",rs.getString(3));
                    request.setAttribute("gender",rs.getString(4));
                    request.setAttribute("birthdate",rs.getString(5));
                    request.getRequestDispatcher("userInfo.jsp").forward(request,response);
                }else{
                    //writer.print("Username or Password Error!!!");
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("message","Username Or Password Error!!");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}