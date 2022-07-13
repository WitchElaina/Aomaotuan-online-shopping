package com.amt.dao;

import com.amt.bean.Goods;

import java.util.List;

public interface GoodsDao {
    public List<Goods> find_all_goods(Goods goods);
    public Goods find_goods_by_id(int id);
}
