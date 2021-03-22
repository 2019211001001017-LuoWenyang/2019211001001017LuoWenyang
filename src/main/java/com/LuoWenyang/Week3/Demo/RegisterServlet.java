package com.LuoWenyang.Week3.Demo;

import com.LuoWenyang.Week3.Demo.DataBase.DB_operation;
import com.LuoWenyang.Week3.Demo.Object.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get parameter from request
        String username =  request.getParameter("username");
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
    }
}
