package com.amt.controller;

import com.amt.service.UsersService;
import com.amt.utils.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userlogin.do")
public class UsersLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("user_pwd");

        password = Md5Util.getHash(password,"md5");
        UsersService usersService = new UsersService();
        Map<String,Object> users = usersService.userLogin(username, password);

        if(users == null) {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("users",users);

            resp.sendRedirect(req.getContextPath()+"/list.jsp");
        }
    }
}
