package com.amt.controller;

import com.amt.bean.Admins;
import com.amt.service.AdminsService;
import com.amt.utils.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/login.do")
public class AdminsLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String adminPass = req.getParameter("adminPass");

        adminPass = Md5Util.getHash(adminPass, "md5");

        AdminsService adminsService = new AdminsService();
        Map<String,Object> admins = adminsService.adminLogin(adminName, adminPass);
        if (admins == null) {
            req.setAttribute("error","Account not found");
            req.getRequestDispatcher("/adminlogin.jsp").forward(req,resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("admins",admins);

            resp.sendRedirect(req.getContextPath()+"/admin/main.jsp");
        }
    }
}
