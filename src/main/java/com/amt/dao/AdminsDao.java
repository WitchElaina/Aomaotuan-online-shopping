package com.amt.dao;

import com.amt.bean.Admins;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AdminsDao {
    public Map<String,Object> adminLogin(@Param("adminName") String adminName, @Param("adminPass") String adminPass);
}
