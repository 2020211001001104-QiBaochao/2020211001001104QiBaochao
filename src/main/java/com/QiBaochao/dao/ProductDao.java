package com.QiBaochao.dao;

import com.QiBaochao.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        System.out.println(con);
        Product product=new Product();
        try{
            String queryString ="select * from Product where ProductId=?";
            System.out.println(productId);
            PreparedStatement pt=con.prepareStatement(queryString);
            pt.setInt(1,productId);
            ResultSet rs=pt.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getInt("ProductId"));
                System.out.println(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("Price"));
                product.setCategoryId(rs.getInt("CategoryId"));
            }
            System.out.println("successful");
        }catch (Exception e) {
            System.out.println(e);
        }

        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {

        System.out.println(con);
        List<Product> list=new ArrayList<Product>();
        try{
            String queryString ="select * from Product where CategoryId=?";
            PreparedStatement pt=con.prepareStatement(queryString);
            pt.setInt(1,categoryId);
            ResultSet rs=pt.executeQuery();
            while (rs.next()) {
                Product product=new Product();
                product.setProductId(rs.getInt("ProductId"));
                System.out.println(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("Price"));
                product.setCategoryId(rs.getInt("CategoryId"));
                list.add(product);
            }
            System.out.println("successful");
        }catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String queryString="select * from Product";
        PreparedStatement pt=con.prepareStatement(queryString);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        System.out.println("successful");
        return list;

    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public byte[] getPictureById(Integer productId,Connection con) throws  SQLException{
        byte[] imgByte=null;
        String sql="select picture from Product where ProductId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()) {
            Blob blob =rs.getBlob("picture");
            imgByte=blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }
}