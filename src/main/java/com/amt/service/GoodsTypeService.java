package com.amt.service;

import com.amt.bean.GoodsType;
import com.amt.dao.GoodsTypeDao;
import com.amt.utils.SqlSessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GoodsTypeService {
    public List<GoodsType> find_all() {
        SqlSession sqlSession = null;
        try {
        sqlSession = SqlSessionUtils.getSqlSession();
        GoodsTypeDao goodsTypeDao = sqlSession.getMapper(GoodsTypeDao.class);
        return goodsTypeDao.find_all();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public GoodsType find_by_name(String type_name) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsTypeDao goodsTypeDao = sqlSession.getMapper(GoodsTypeDao.class);
            return goodsTypeDao.find_by_name(type_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public PageInfo<GoodsType> findByPage(int currentPage, String type_name) {
        SqlSession sqlSession = null;
        PageInfo<GoodsType> pageInfo = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsTypeDao goodsTypeDao = sqlSession.getMapper(GoodsTypeDao.class);
            PageHelper.startPage(currentPage,4);
            List<GoodsType> goodsTypeList = goodsTypeDao.findByTypeName(type_name);
            pageInfo = new PageInfo<>(goodsTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
}
