package com.amt.controller;

import com.alibaba.fastjson.JSON;
import com.amt.bean.GoodsType;
import com.amt.service.GoodsService;
import com.amt.service.GoodsTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/admin/goods/ajax.do")
public class AjaxController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf8");
        List<GoodsType> all = new GoodsTypeService().find_all();
        String ret = JSON.toJSONString(all);
        System.out.println(ret);
//        resp.getOutputStream().write(ret.getBytes(StandardCharsets.UTF_8));
        resp.getWriter().write(ret);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
