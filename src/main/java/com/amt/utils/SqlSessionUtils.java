package com.amt.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {
    public static SqlSession getSqlSession() throws Exception {
        // create SqlSession factory using Mybatis xml configuration
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
        // create session object
        SqlSession sqlSession =sqlSessionFactory.openSession();
        return sqlSession;
    }
}
