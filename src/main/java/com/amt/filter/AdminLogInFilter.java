package com.amt.filter;

import com.amt.bean.Admins;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "AdminLoginFilter", urlPatterns = {"*.jsp", "*.do"})
public class AdminLogInFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        if (!uri.contains("login.do") && !uri.contains("register.do") && !uri.contains("login.jsp") && !uri.contains("adminlogout.jsp") && !uri.contains("register.jsp") && !uri.contains("list.jsp")) {
            HttpSession session =request.getSession();
            Map<String,Object> admins = (Map<String,Object>) session.getAttribute("admins");

            if(admins==null) {
                response.sendRedirect(request.getContextPath()+"/adminlogin.jsp");
                return;
            }

        }



        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
