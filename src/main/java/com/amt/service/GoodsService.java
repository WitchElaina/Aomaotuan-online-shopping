package com.amt.service;

import com.amt.bean.Goods;
import com.amt.dao.GoodsDao;
import com.amt.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GoodsService {
    public List<Goods> find_all_goods(Goods goods) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
            return goodsDao.find_all_goods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public Goods find_goods_by_id(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
            return goodsDao.find_goods_by_id(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}