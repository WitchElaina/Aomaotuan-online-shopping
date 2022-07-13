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

@WebServlet("/admin/goods/showgoods.do")
public class GoodsController extends HttpServlet{
    // redirect POST to GET
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
    // override a tag GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        // get request args
        String currentPage =req.getParameter("currentPage");
        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }

        String goods_name = req.getParameter("goods_name");
        String min_price = req.getParameter("min_price");
        String max_price = req.getParameter("max_price");
        String type_name = req.getParameter("type_name");

        Goods goods = new Goods();
        goods.setGoods_name(goods_name);
        if("".equals(goods_name)) {
            goods_name = null;
        }
        if("".equals(type_name)) {
            type_name = null;
        }
        goods.setType_name(type_name);
//        goods.setGoods_price(min_price==null?null:Double.parseDouble(min_price));
//        goods.setEnd_goods_price(max_price==null?null:Double.parseDouble(max_price));
        if(min_price != null && !"".equals(min_price)) {
            goods.setGoods_price(Double.parseDouble(min_price));
        }
        if(max_price != null && !"".equals(max_price)) {
            goods.setEnd_goods_price(Double.parseDouble(max_price));
        }
        System.out.println("Goods: "+goods.toString());

        // call services methods
        PageHelper.startPage(Integer.parseInt(currentPage),4);
        GoodsService goodsService = new GoodsService();
        List<Goods> all_goods = goodsService.find_all_goods(goods);
        System.out.println(all_goods);

        PageInfo<Goods> pageInfo = new PageInfo<>(all_goods);

        List<GoodsType> goodsTypes = new GoodsTypeService().find_all();

        // response
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("goods", all_goods);
        req.setAttribute("goodsTypes", goodsTypes);
        req.setAttribute("good",goods);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
}
