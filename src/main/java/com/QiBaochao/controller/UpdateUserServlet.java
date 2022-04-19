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

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(String.valueOf(Date.valueOf(birthday)));

        UserDao userDao = new UserDao();
        ServletContext application = getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        int num = 0;
        try {
            num = userDao.updateUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (num != 0){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Update fail!");
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
        }
    }
}