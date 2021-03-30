package com.LuoWenyang.Week4.Demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// user @webservlet  - no web.xml code
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name = "driver",value = "com.mysql.cj.jdbc.Driver"),
                @WebInitParam(name = "url",value = "jdbc:mysql://localhost:3306/userdb"),
                @WebInitParam(name = "username",value = "root"),
                @WebInitParam(name = "password",value = "lwy5687605682")
        }//,loadOnStartup = 1
)

public class JDBCDemoServlet extends HttpServlet {
        Connection con = null;
    @Override
    public void init() throws ServletException {
        //String driver = "com.mysql.cj.jdbc.Driver";
        //String url = "jdbc:mysql://localhost:3306/userdb";
        //String username = "root";
        //String password = "lwy5687605682";
        //code like is bad way   because change is not easy

        //ger servletconfig --> getInitParmeters

        ServletConfig config = getServletConfig();
        String driver =  config.getInitParameter("driver");
        String url =  config.getInitParameter("url");
        String username =  config.getInitParameter("username");
        String password =  config.getInitParameter("password");

        try {
            Class.forName(driver);
            con =DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("i am  in doGet() ");
        String sql = "SELECT * FROM usertable";
        try {
          ResultSet resultSet =  con.createStatement().executeQuery(sql);
          while (resultSet.next())
          {
              System.out.println(resultSet.getString(1));
              System.out.println(resultSet.getString(2));
              System.out.println(resultSet.getString(3));
              System.out.println(resultSet.getString(4));
          }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
