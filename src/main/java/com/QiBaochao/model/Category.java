package com.QiBaochao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean active;
    public Category(){

    }

    public Category(int categoryId, String categoryName, String description, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
    public static List<Category> findAllCategory(Connection con) {
        String dbRequire="select * from Category";
        List<Category> list=new ArrayList<Category>();
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            while(resultDb.next()) {
                Category c=new Category();
                c.setCategoryId(resultDb.getInt("CategoryId"));
                System.out.println(resultDb.getInt("CategoryId"));
                c.setCategoryName(resultDb.getString("CategoryName"));
                c.setDescription(resultDb.getString("Description"));
                list.add(c);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static  String findByCategoryId(Connection con,int categoryId) throws SQLException {
        String categoryName=null;
        try{
            String dbRequire="select CategoryName from Category where CategoryId=?";
            PreparedStatement st=con.prepareStatement(dbRequire);
            st.setInt(1,categoryId);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                categoryName=resultDb.getString("CategoryName");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return categoryName;
    }
}