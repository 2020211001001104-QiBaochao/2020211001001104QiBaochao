package com.QiBaochao.week4.homework;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name",value = "QiBaochao"),
                @WebInitParam(name = "studentId",value = "2020211001001104")
        },
        loadOnStartup = 1
)

public class ConfigDemoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");

        PrintWriter out = response.getWriter();
        out.println("<br/>name:"+name);
        out.println("<br/>studentId:"+studentId);
    }
}