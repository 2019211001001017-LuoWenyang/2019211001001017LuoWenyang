package com.LuoWenyang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category implements java.io.Serializable {
    private int categoryId;
    private String categoryName;
    private String description;
    private Boolean active;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String description, Boolean active) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
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

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql = "SELECT * FROM  Category ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        Category category = null;
        List<Category>  categoryList = new ArrayList<Category>();
        while(resultSet.next())
        {
            category = new Category();
            category.setCategoryId(resultSet.getInt("categoryId"));
            category.setCategoryName(resultSet.getString("categoryName"));
            category.setDescription(resultSet.getString("description"));
            categoryList.add(category);
        }
        return categoryList;
    }

    public static String findByCategoryId(Connection con,int categoryId)  {
        String categoryName = null;
        try {
            String sql = "SELECT categoryName FROM  Category WHERE categoryId = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                categoryName = resultSet.getString("categoryName");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categoryName;
    }
}
