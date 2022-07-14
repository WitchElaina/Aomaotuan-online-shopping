package com.amt.service;

import com.amt.bean.Admins;
import com.amt.dao.AdminsDao;
import com.amt.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class AdminsService {
    public Map<String,Object> adminLogin(String adminName, String adminPass) {
        SqlSession sqlSession = null;
        Map<String,Object> admins = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            AdminsDao adminsDao = sqlSession.getMapper(AdminsDao.class);
            admins = adminsDao.adminLogin(adminName, adminPass);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return admins;


    }
}
