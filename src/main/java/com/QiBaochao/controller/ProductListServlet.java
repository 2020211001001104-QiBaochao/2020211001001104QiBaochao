package com.QiBaochao.controller;

import com.QiBaochao.dao.ProductDao;
import com.QiBaochao.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ProductDao productDao=new ProductDao();
            List<Product> productList=productDao.findAll((Connection)getServletContext().getAttribute("con"));
            System.out.println(productList);
            request.setAttribute("productList",productList);
        }catch (Exception e) {
            System.out.println(e);
        }
        String path="/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}