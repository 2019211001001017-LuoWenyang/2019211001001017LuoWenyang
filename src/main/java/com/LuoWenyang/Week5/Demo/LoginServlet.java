package com.LuoWenyang.Week5.Demo;

import com.LuoWenyang.dao.UserDao;
import com.LuoWenyang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
//        ServletContext servletContext = getServletContext();
//        String driver =  servletContext.getInitParameter("driver");
//        String url =  servletContext.getInitParameter("url");
//        String username =  servletContext.getInitParameter("username");
//        String password =  servletContext.getInitParameter("password");
//        System.out.println(driver+url+username+password);
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url,username,password);
//            System.out.println("init()-->"+con);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        //only one one
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           // doPost(request,response);

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username =  request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
          User user =  userDao.findByUsernamePassword(con,username,password);//this mt
            if(user!=null)
            {//valid
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                //invalid
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//        System.out.println(username+password);//check the username and password
//
//        try {
//            String sql = "SELECT * FROM  usertable WHERE username =? and password =?";
//            ResultSet resultSet;
//            Statement stmt = con.createStatement();
//            PreparedStatement ps;
//            ps = con.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//            resultSet = ps.executeQuery();
//            //if(LoginCheck(username,password))
//            if(resultSet.next())
//            {
////                PrintWriter writer = response.getWriter();
////                writer.println("Login Success!!! ");
////                writer.println("Welcome:"+username);
//                request.setAttribute("Id",resultSet.getInt("id"));
//                request.setAttribute("username",resultSet.getString("username"));
//                request.setAttribute("password",resultSet.getString("password"));
//                request.setAttribute("email",resultSet.getString("email"));
//                request.setAttribute("gender",resultSet.getString("gender"));
//                request.setAttribute("birthdate",resultSet.getString("birthdate"));
//
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//
//
//            }else {
////                PrintWriter writer = response.getWriter();
////                writer.println("Login Fail!!! ");
////                writer.println(" Wrong Password or Wrong Username ");
//                request.setAttribute("message","Username or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


    }

//
//    private boolean LoginCheck(String username, String password) throws SQLException {
//        String sql = "SELECT * FROM  usertable WHERE username =? and password =?";
//        ResultSet resultSet;
//        Statement stmt = con.createStatement();
//        PreparedStatement ps;
//        ps = con.prepareStatement(sql);
//        ps.setString(1, username);
//        ps.setString(2, password);
//        resultSet = ps.executeQuery();
//        if(resultSet.next()){
//            resultSet.close();
//            ps.close();
//            stmt.close();
//            return true;  //success
//        }else {
//            resultSet.close();
//            ps.close();
//            stmt.close();
//            return false;  //fail
//        }
//
//
//    }

}
