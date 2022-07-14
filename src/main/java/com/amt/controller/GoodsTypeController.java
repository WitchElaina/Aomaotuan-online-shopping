package com.amt.controller;

import com.amt.bean.GoodsType;
import com.amt.service.GoodsTypeService;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goodtype/goodtype.do")
public class GoodsTypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "showallgoodstype":
                showAllGoodsType(req,resp);
                break;
            case "delete_goods_type":
                deleteGoodsTypeById(req,resp);
                break;
            case "batch_delete_type_by_id":
                batchDeleteTypebyId(req,resp);
                break;
            case "to_update_page":
                toUpdatePage(req,resp);
                break;
            case "update_type":
                updateType(req,resp);
                break;
            case "save_type":
                saveType(req, resp);
            default:break;
        }
    }

    private void saveType(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateType(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void toUpdatePage(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void batchDeleteTypebyId(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteGoodsTypeById(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showAllGoodsType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        String type_name = req.getParameter("type_name");
        GoodsTypeService goodsTypeService = new GoodsTypeService();

        PageInfo<GoodsType> pageInfo = goodsTypeService.findByPage(Integer.parseInt(currentPage), type_name);

        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("typeName", type_name);
        req.setAttribute("currentPage",currentPage);
        if(pageInfo==null) {
            IOException exception = new IOException("Type not found!");
            throw exception;
        }
        req.setAttribute("goodsType",pageInfo.getList());
        req.getRequestDispatcher("/admin/goodstype/show.jsp").forward(req,resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
