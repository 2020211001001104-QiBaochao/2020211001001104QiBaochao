package com.QiBaochao.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:QiBaochao");
        writer.println("ID:2020211001001104");
        Date date=new Date();
        writer.println("Date and Time"+date.toString());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}