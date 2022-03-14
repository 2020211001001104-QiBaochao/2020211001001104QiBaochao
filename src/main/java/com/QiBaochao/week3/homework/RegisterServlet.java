package com.QiBaochao.week3.homework;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet (name = "RegisterServlet", value = "/register")


public class RegisterServlet extends HttpServlet {
    Connection con =null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*
        String driver = getServletConfig().getServletContext().getInitParameter("driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String username = getServletConfig().getServletContext().getInitParameter("username");
        String password = getServletConfig().getServletContext().getInitParameter("password");
        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("init()" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("src/main/webapp/week2/register.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthdate)" +
                    "values('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthDate +"')";
            System.out.println("sql " + sql);

            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);

            sql = "select * from usertable";
            ResultSet rs = st.executeQuery(sql);
            PrintWriter out = response.getWriter();

            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);

            response.sendRedirect("login");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void destroy(){
        super.destroy();
        try{
            con.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}