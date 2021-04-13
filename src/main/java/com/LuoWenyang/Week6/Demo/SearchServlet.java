package com.LuoWenyang.Week6.Demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String txt = request.getParameter("txt");
        System.out.println(txt);
        String[] SearchSite = request.getParameterValues("search");
        System.out.println(SearchSite[0]);
            if(txt.equals("")){
                response.sendRedirect("index.jsp");
            }else {
                if(SearchSite[0].equals("baidu")){
                    response.sendRedirect("https://www.baidu.com/s?wd="+txt);
                }
                else if(SearchSite[0].equals("bing")){
                    response.sendRedirect("https://cn.bing.com/search?q="+txt);
                }
                else if(SearchSite[0].equals("google")){
                    response.sendRedirect("https://www.google.com/search?q="+txt);
                }
            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request,response);
    }
}
