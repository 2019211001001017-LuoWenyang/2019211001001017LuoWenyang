package com.LuoWenyang.controller;

import com.LuoWenyang.dao.ProductDao;
import com.LuoWenyang.model.Category;
import com.LuoWenyang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Category> categoryList = null;
        try {
            categoryList = Category.findAllCategory(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);
        ProductDao productDao = new ProductDao();
        try {
            if(request.getParameter("categoryId")==null){
                List<Product> productList = productDao.findAll(con);
                request.setAttribute("productList",productList);
            }
            else {
                int catId = Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList = productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
