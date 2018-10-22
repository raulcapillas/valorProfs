package com.valorProfs.services;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyBatisService {

    private SqlSessionFactory sessionFactory;

    public MyBatisService() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.out.println("Mybatis configuration file doesn't read it: "+e.getMessage());
        }

        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
