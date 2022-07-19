package com.amt.service;

import com.amt.dao.UsersDao;
import com.amt.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

public class UsersService {
    public Map<String,Object> userLogin(String username, String password) {
        SqlSession sqlSession = null;
        Map<String,Object> users = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            users = usersDao.userLogin(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return users;
    }

    public int userRegister(String username, String password) {
        SqlSession sqlSession = null;
        Map<String,Object> users = null;
        int ret = 0;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            ret = usersDao.userRegister(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return ret;
    }
}
