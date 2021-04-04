package com.LuoWenyang.Week5.Demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        String driver =  servletContext.getInitParameter("driver");
        String url =  servletContext.getInitParameter("url");
        String username =  servletContext.getInitParameter("username");
        String password =  servletContext.getInitParameter("password");
        System.out.println(driver+url+username+password);
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username =  request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);//check the username and password

        try {
            if(LoginCheck(username,password)){
                PrintWriter writer = response.getWriter();
                writer.println("Login Success!!! ");
                writer.println("Welcome:"+username);

            }else {
                PrintWriter writer = response.getWriter();
                writer.println("Login Fail!!! ");
                writer.println(" Wrong Password or Wrong Username ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private boolean LoginCheck(String username,String password) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE username =? and password =?";
        ResultSet resultSet;
        Statement stmt = con.createStatement();
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        resultSet = ps.executeQuery();
        if(resultSet.next()){
            resultSet.close();
            ps.close();
            stmt.close();
            return true;  //success
        }else {
            resultSet.close();
            ps.close();
            stmt.close();
            return false;  //fail
        }


    }

}
