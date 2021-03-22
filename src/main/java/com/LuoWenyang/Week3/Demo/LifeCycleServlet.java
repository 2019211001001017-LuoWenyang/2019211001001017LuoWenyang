package com.LuoWenyang.Week3.Demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {

    // 1.tomacate read web.xml file and find all servlet class

     // 2.load servlet - when ? 2 . first request for this servlet come in - from client
    // 3.call default constructor - add code
    public  LifeCycleServlet() {
        System.out.println("i am in constructor --> LifeCycleServlet()");
    }



    //4.init() - add code
    public void init(){
        System.out.println("i am in init()  ");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("i am in service() --> doGet() ");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("i am in service() --> doPost()  ");
    }

    @Override
    public void destroy() {
       System.out.println(" i am in destroy()");
    }
}
