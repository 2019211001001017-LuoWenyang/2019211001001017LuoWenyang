package com.lab2;

import javax.servlet.*;

import java.io.IOException;


public class LuoWenyangFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LuoWenyangFilter --> before chain");
        chain.doFilter(request, response);
        System.out.println("LuoWenyangFilter --> after chain");
    }
}
