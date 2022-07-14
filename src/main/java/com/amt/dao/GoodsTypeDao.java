package com.amt.dao;

import com.amt.bean.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public List<GoodsType> find_all();
    public GoodsType find_by_name(String type_name);

    List<GoodsType> findByTypeName(String type_name);
}
