package com.amt.controller;

import com.amt.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods/batchdelete.do")
public class GoodsBatchDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String ids = req.getParameter("ids");
        String[] idsArray = ids.split(",");

        int i = new GoodsService().batchDeleteById(idsArray);
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
