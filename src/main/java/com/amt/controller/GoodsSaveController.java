package com.amt.controller;

import com.amt.bean.Goods;
import com.amt.service.GoodsService;
import com.amt.service.GoodsTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods/save.do")
public class GoodsSaveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String goodsName = req.getParameter("goodsName");
        double goodsPrice = Double.parseDouble(req.getParameter("goodsPrice"));
        int goodsNum = Integer.parseInt(req.getParameter("goodsNum"));
        System.out.println(req.getParameter("goodsType"));
        String goodsType = req.getParameter("goodsType");
        GoodsTypeService goodsTypeService = new GoodsTypeService();
        int goodsTypeId = goodsTypeService.find_by_name(goodsType).getType_id();
        String goods_img = req.getParameter("goods_img");


        Goods goods = new Goods();
        goods.setGoods_name(goodsName);
        goods.setGoods_price(goodsPrice);
        goods.setGoods_num(goodsNum);
        goods.setType_id(goodsTypeId);
        goods.setGoods_img(goods_img);

        GoodsService goodsService = new GoodsService();
        int i = new GoodsService().saveGoods(goods);
        if(i<=0) {
            try {
                throw new Exception("Change Failed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/admin/goods/showgoods.do");
//            req.getRequestDispatcher("/admin/goods/showgoods.do").forward(req,resp);
        }
    }
}
