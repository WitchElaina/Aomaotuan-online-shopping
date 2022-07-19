package com.amt.controller;

import com.amt.bean.UserAccounts;
import com.amt.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addtocart.do")
public class UsersAddToCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goods_id = req.getParameter("goods_id");
        String uid = req.getParameter("uid");
        String user_package = req.getParameter("user_package");
        HttpSession session = req.getSession();

        if(user_package.equals("")) {
            new UsersService().addToCart(goods_id,uid);
            session.setAttribute("cart",goods_id);
        }
        else {
            new UsersService().addToCart(user_package+","+goods_id,uid);
            session.setAttribute("cart",user_package+","+goods_id);
        }
        resp.sendRedirect(req.getContextPath()+"/showgoods.do");
    }
}
