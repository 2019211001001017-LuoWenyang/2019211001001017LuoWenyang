package com.LuoWenyang.dao;

import com.LuoWenyang.model.Product;


import java.io.InputStream;
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
            //pt.setBinaryStream(3, product.getPicture());
            //for mysql
               pt.setBlob(3, product.getPicture());
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
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "DELETE FROM product WHERE productId=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        return ps.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "UPDATE product SET productName=?,productDescription=?,picture=?,price=?,categoryId=? WHERE productId=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, instance.getProductName());
        ps.setString(2, instance.getProductDescription());
        ps.setBlob(3, instance.getPicture());
        ps.setDouble(4, instance.getPrice());
        ps.setInt(5,instance.getCategoryId());
        ps.setInt(6, instance.getProductId());
        return  ps.executeUpdate();
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * FROM product WHERE productId = ? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        if(resultSet.next())
        {
            product = new Product();
            product.setProductId(productId);
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture((InputStream) resultSet.getBlob("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql = "SELECT * FROM  product WHERE categoryId =? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, categoryId);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        List<Product>  productList = new ArrayList<Product>();
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getInt("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture((InputStream) resultSet.getBlob("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "SELECT * FROM  product WHERE price between  ? and ?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setDouble(1, minPrice);
        ps.setDouble(2,maxPrice);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        List<Product>  productList = new ArrayList<Product>();
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getInt("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture((InputStream) resultSet.getBlob("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = "SELECT * FROM  product ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        List<Product>  productList = new ArrayList<Product>();
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getInt("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture((InputStream) resultSet.getBlob("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT * FROM  product WHERE  productName");
        sql.append(" and productName like '%"+productName+"%'");
        PreparedStatement ps;
        ps = con.prepareStatement(sql.toString());
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        List<Product>  productList = new ArrayList<Product>();
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getInt("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture((InputStream) resultSet.getBlob("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * FROM  product WHERE productId = ? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        List<Product>  productList = new ArrayList<Product>();
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getInt("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture((InputStream) resultSet.getBlob("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));// why getPicture by id return a list?
            productList.add(product);
        }
        return productList;
    }

    public byte[] getPictureById(Integer productId,Connection con) throws SQLException {
        byte[] imgByte = null;
        String sql = "select picture from product where productId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,productId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Blob blob = rs.getBlob("picture");
            imgByte = blob.getBytes(1,(int)blob.length());

        }
        return imgByte;
    }
}
