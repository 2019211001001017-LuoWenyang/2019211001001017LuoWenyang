package com.LuoWenyang.Week3.Demo;

import com.LuoWenyang.Week3.Demo.Object.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* week 4 code */
@WebServlet(
        urlPatterns = {"/register"}
)

public class RegisterServlet extends HttpServlet {

    /* week 4 code */
    Connection con = null;
    @Override
    public void init() throws ServletException {
        /* week 4 code */
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






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* week 3 code */

        // get parameter from request
       /* String username =  request.getParameter("username");
        String password =  request.getParameter("password");
        String email =  request.getParameter("email");
        String gender =  request.getParameter("gender");
        String birthDate =  request.getParameter("birthDate");

        User user = new User();
        user.username = username;
        user.password = password;
        user.email = email;
        user.gender = gender;
        user.birthDate = birthDate;

        DB_operation db_operation = new DB_operation();
        try {
            db_operation.InsertUser(user);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br>username: "+username);
        writer.println("<br>password: "+password);
        writer.println("<br>email: "+email);
        writer.println("<br>gender: "+gender);
        writer.println("<br>birthDate: "+birthDate);
        writer.close();
        */

        /* week 4 code */
        // add a row into database table "usertable"  -- i want to use a method
        InsertUser(request);
        //Print all rows use html<table><tr><td>   -- i want to use a method
        PrintAllUserInfo(response);
    }

    /* week 4 code */
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void InsertUser(HttpServletRequest request)
    {
        String username =  request.getParameter("username");
        String password =  request.getParameter("password");
        String email =  request.getParameter("email");
        String gender =  request.getParameter("gender");
        String birthDate =  request.getParameter("birthDate");

        String sql = "INSERT INTO usertable(username,password,email,gender,birthdate) VALUES (?,?,?,?,?)";

        int resultSet;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,birthDate);
            resultSet = ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void PrintAllUserInfo(HttpServletResponse response)
    {
        String sql = "SELECT * FROM usertable";
        Statement statement = null ;
        ResultSet resultSet = null ;
        List <User> list = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setGender(resultSet.getString(5));
                user.setBirthDate(resultSet.getString(6));
                list.add(user);
            }
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                response.setContentType("text/html;charset=utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.println("<table border=\"1\">");
            writer.println("<tr>");
            writer.println("<td>ID</td>");
            writer.println("<td>UserName</td>");
            writer.println("<td>Password</td>");
            writer.println("<td>Email</td>");
            writer.println("<td>Gender</td>");
            writer.println("<td>Birthday</td>");
            writer.println("</tr>");
            for (User user : list) {
                writer.println("<tr>");
                writer.println("<td>"+user.getId()+"</td>");
                writer.println("<td>"+user.getUsername()+"</td>");
                writer.println("<td>"+user.getPassword()+"</td>");
                writer.println("<td>"+user.getEmail()+"</td>");
                writer.println("<td>"+user.getGender()+"</td>");
                writer.println("<td>"+user.getBirthDate()+"</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.close();
        }

    }
}
