package com.amt.dao;

import com.amt.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    public List<Goods> find_all_goods(Goods goods);
    public Goods find_goods_by_id(int id);
    public int modify_goods(Goods goods);
    public int delete_by_id(int id);
    public int saveGoods(Goods goods);
    public int batchDeleteById(@Param("idsArray") String[] idsArray);
}
