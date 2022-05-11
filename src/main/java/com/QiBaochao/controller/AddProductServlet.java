package com.QiBaochao.controller;


import com.QiBaochao.model.Category;
import com.QiBaochao.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
        con=(Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList= Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            //we will use latter
            String path="/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all prameters
        String productName=request.getParameter("productName");
        double price=request.getParameter("price")!=null? Double.parseDouble(request.getParameter("price")):0.0;//if null error
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):8;
        String productDescription = request.getParameter("productDescription");

        //get picture
        InputStream inputStream=null;
        Part filePart=request.getPart("picture");//baidu
        if(filePart!=null){
            inputStream=filePart.getInputStream();
        }
        //set into model
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        //call same in dao
        com.QiBaochao.dao.ProductDao productDao=new com.QiBaochao.dao.ProductDao();
        try {
            int n=productDao.save(product,con);
            //redirect
            if (1>0)
                response.sendRedirect("productList");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
