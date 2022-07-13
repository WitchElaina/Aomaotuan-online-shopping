package com.amt.controller;

import com.amt.bean.Goods;
import com.amt.bean.GoodsType;
import com.amt.service.GoodsService;
import com.amt.service.GoodsTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/goods/toupdate.do")
public class GoodsUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get Argus
        String goodsName = req.getParameter("goodsName");
        String goodsId = req.getParameter("goodsId");
        String goodsPrice = req.getParameter("goodsPrice");
        String goodsNum = req.getParameter("goodsNum");
        String goods_type_name = req.getParameter("goodsType");

        // find type id
        GoodsType by_name = new GoodsTypeService().find_by_name(goods_type_name);
        Goods goods = new Goods(Integer.parseInt(goodsId), goodsName, Double.parseDouble(goodsPrice), Integer.parseInt(goodsNum), goods_type_name, by_name.getType_id());




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("goodsId");
        if(goodsId != null && !"".equals(goodsId)) {
            Goods goods_by_id = new GoodsService().find_goods_by_id(Integer.parseInt(goodsId));
            List<GoodsType> goodsTypes = new GoodsTypeService().find_all();
            System.out.println(goods_by_id);

            req.setAttribute("goods",goods_by_id);
            req.setAttribute("goodsTypes", goodsTypes);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }
        else {
            try {
                throw new Exception("Invalid ID!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
