package com.demo.mybatis.sqlSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionManager {

    private static final String CONFIG_FILE = "mybatis-config.xml";

    private static final SqlSessionManager SESSION_MANAGER = new SqlSessionManager();

    private  SqlSessionFactory build;

    public static SqlSessionManager getInstance() {
        return SESSION_MANAGER;
    }


    private SqlSessionManager(){
        this.initSessionFactory();
    }


    private  void initSessionFactory(){
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(CONFIG_FILE);
            build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (resourceAsStream!=null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SqlSession openSqlSession(){
        if (build==null)return null;
        return build.openSession();
    }
}
