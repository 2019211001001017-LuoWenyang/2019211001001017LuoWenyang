package com.LuoWenyang.Week2.Demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// not it's just a java class
//extend HttpServlet
@WebServlet("/StuInfo")
public class HelloWorldServlet extends HttpServlet {
    String name = "LuoWenyang";
    String ID = "2019211001001017";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // when client request method is GET - here - inside doGet()
        // We want send Hello to Client
        // We need to write Hello in response
        // get writer - java.io
       // PrintWriter writer = response.getWriter();
        //writer.println("Hello Client !!!");
        // next we need to tell about this servlet to tomcat -how ? - web.xml
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Date date = new Date();
        writer.println("Name:"+name+"<br/>");
        writer.println("ID:"+ID+"<br/>");
        writer.println("Date and Time:"+date.toString()+"<br/>");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    {

    }
}
