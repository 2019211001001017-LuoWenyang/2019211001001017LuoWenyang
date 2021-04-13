package com.LuoWenyang.Week6.Demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// tell tomcat this class is a listener calss - how?
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // like  a main() method for this web app
        // called when tomcat start
        // use this method to create jdbc connection
       // System.out.println("i am in contextInitialized()");

        ServletContext servletContext =sce.getServletContext();
        String driver =  servletContext.getInitParameter("driver");
        String url =  servletContext.getInitParameter("url");
        String username =  servletContext.getInitParameter("username");
        String password =  servletContext.getInitParameter("password");
        System.out.println(driver+url+username+password);
        try {
            Class.forName(driver);
          Connection con = DriverManager.getConnection(url,username,password);
          System.out.println("i am in contextInitialized()-->"+con);
          //set connection as context attribute -- for all jsp and servlet
          servletContext.setAttribute("con",con);  // name = value
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
            // end point of web app
            // this method called when tomcat stop
        System.out.println("i am in contextDestroyed()");
        // remove connection from context
        sce.getServletContext().removeAttribute("con");
    }
}
