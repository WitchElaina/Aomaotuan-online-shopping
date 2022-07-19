package com.amt.controller;

import com.amt.bean.Goods;
import com.amt.bean.GoodsType;
import com.amt.service.GoodsService;
import com.amt.service.GoodsTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showgoods.do")
public class UsersGoodsController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage =req.getParameter("currentPage");
        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }

        String goods_name = req.getParameter("goods_name");
        Goods goods = new Goods();
        goods.setGoods_name(goods_name);

        // call services methods
        PageHelper.startPage(Integer.parseInt(currentPage),4);
        GoodsService goodsService = new GoodsService();
        List<Goods> all_goods = goodsService.find_all_goods(goods);
//        System.out.println(all_goods);

        PageInfo<Goods> pageInfo = new PageInfo<>(all_goods);

        List<GoodsType> goodsTypes = new GoodsTypeService().find_all();

        // response
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("goods", all_goods);
        req.setAttribute("goodsTypes", goodsTypes);
        req.setAttribute("good",goods);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
