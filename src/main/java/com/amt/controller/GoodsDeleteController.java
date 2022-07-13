package com.amt.controller;

import com.amt.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods/todelete.do")
public class GoodsDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String goodsId = req.getParameter("goodsId");

        int i = new GoodsService().delete_by_id(Integer.parseInt(goodsId));
        if(i<0) {
            try {
                throw new Exception("Delete Failed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            req.getRequestDispatcher("/admin/goods/showgoods.do").forward(req,resp);
        }
    }
}
