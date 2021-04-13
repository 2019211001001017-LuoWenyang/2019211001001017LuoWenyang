package com.LuoWenyang.Week6.Demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect -same server - Relative  URL
        // 1.start without /
        // 2.start with /

        System.out.println("before redirect ");

        //response.sendRedirect("index.jsp");

        System.out.println("after redirect");

       // response.sendRedirect("/2019211001001017LuoWenyang_war_exploded/index.jsp");
        //redirect -anther server -Absolute URL
//        http://localhost:8080/2019211001001017LuoWenyang_war_exploded/index.jsp
        response.sendRedirect("https://www.baidu.com/");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
