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

@WebServlet("/userregister.do")
public class UsersRegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        password = Md5Util.getHash(password,"md5");
        UsersService usersService = new UsersService();
        int registerState = usersService.userRegister(username, password);
        HttpSession session = req.getSession();
        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }
}
