package com.LuoWenyang.controller;

import com.LuoWenyang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);//return session
        if(session!=null&&session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            System.out.println(user.getUsername());
            if("admin".equals(user.getUsername())){
                System.out.println(user.getUsername());
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            }else {
                //have session but its not admin user
                session.invalidate();//kill
                request.setAttribute("message","Unauthorized Access Admin Module!!!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            }
        }else {
            //no session - then user click the link
            request.setAttribute("message","Please login as admin !!!");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
