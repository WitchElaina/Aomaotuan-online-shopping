package com.amt.controller;

import com.amt.bean.Goods;
import com.amt.service.GoodsService;
import com.amt.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/showcart.do")
public class UsersCartShowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cart_str = req.getParameter("cart");
        List<String> cart_list = Arrays.asList(cart_str.split(","));
        GoodsService goodsService = new GoodsService();
        List<Goods> cart = new ArrayList<>();
//        List<Map<String,Object>> cart = new ArrayList<>();
        Goods cur = null;
        Map<String,Object> cur_map = new HashMap<>();
        for (String goods_id:cart_list) {
            cart.add(goodsService.find_goods_by_id(Integer.parseInt(goods_id)));
//            cur_map.put("goods_name",cur.getGoods_name());
//            cur_map.put("goods_prices",cur.getGoods_price());
//            cart.add(cur_map);
        }
        HttpSession session = req.getSession();
        session.setAttribute("goods",cart);
        resp.sendRedirect(req.getContextPath()+"/cart.jsp");
    }
}
