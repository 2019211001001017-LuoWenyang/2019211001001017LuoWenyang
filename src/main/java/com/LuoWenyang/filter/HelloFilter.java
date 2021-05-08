package com.LuoWenyang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//2 way of - mapping filter to servalet
//way 1 wexb.xml
//way 2 user webfilter
@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"}
)

//url /hello filter is only for one servlet -- hello servlet
// url /* for all filter
//for these 3 url only
public class HelloFilter implements Filter {// remember
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter --> init()");// when called?

    }

    public void destroy() {
        System.out.println("i am in HelloFilter --> destory()");// when called?
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
       //request come here -- before go to servlet - doGet() or doPost()
        System.out.println("i am in HelloFilter --> doFilter()- before servlet(request come here ");// when called?
        chain.doFilter(request, response);//call next filter - if no next filter - then go to servlet
        //response after servelt come back here
        System.out.println("i am in HellloFilter-->doFilter() -AFTER servlet (response come here)");
    }
}
