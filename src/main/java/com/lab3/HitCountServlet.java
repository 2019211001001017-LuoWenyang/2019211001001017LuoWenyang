package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCount")
public class HitCountServlet extends HttpServlet {
    private  int count = 0;
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<center>");
        out.println("<h1>Total Number of Hits</h1>");
        out.println("<h1>"+count+"</h1>");
        out.print("</center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
