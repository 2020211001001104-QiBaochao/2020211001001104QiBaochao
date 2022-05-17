package com.QiBaochao.controller;

import com.QiBaochao.dao.ProductDao;
import com.QiBaochao.model.Product;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "/admin/productList",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            ProductDao productDao = new ProductDao();
            Connection con ;
            con = (Connection) getServletContext().getAttribute("con");
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList",productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path="/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}