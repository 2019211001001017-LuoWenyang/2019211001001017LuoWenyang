package com.LuoWenyang.controller;


import com.LuoWenyang.dao.UserDao;
import com.LuoWenyang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          // write code
        // forward to WEB-INF/views/updateUser.jsp
        request.getRequestDispatcher("WEB-INF/views/updateUserView.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // writer code to update user info -can  update password,email ,gender,birthDate
        // 1:get all(6) request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        //System.out.println(id);
        String username =  request.getParameter("username");
        String password =  request.getParameter("password");
        String email =     request.getParameter("email");
        String gender =    request.getParameter("gender");
        Date birthDate = Date.valueOf(request.getParameter("birthdate"));

        //2. create an object of User Model
        User user = new User();
        //3. set all 6 request parameters values in to User model -setXXX()
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(birthDate);
        //4.create an Object UserDao
        UserDao userDao = new UserDao();
        //5. call updateUser() in UserDao
        Connection con = (Connection) getServletContext().getAttribute("con");
        try {
            if(userDao.updateUser(con,user)!=0) {
                User user1=userDao.findByUsernamePassword(con,username,password);
                HttpSession session=request.getSession();
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user1);
                request.getRequestDispatcher("accountDetails").forward(request, response);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
}
}
