package com.QiBaochao.controller;

import com.QiBaochao.dao.UserDao;
import com.QiBaochao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet" ,value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    public void init() throws SecurityException, ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(String.valueOf(Date.valueOf(birthDate)));
        UserDao userDao = new UserDao();
        try{
            int a =  userDao.updateUser(con,user);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/views/userList.jsp").forward(request,response);
    }
}