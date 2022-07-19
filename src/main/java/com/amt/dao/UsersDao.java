package com.amt.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UsersDao {
    public Map<String,Object> userLogin(@Param("username") String username,@Param("password") String password);
    public int userRegister(@Param("username") String username,@Param("password") String password);
}
