package com.birdboot.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    //1、数据库连接池
    private static DruidDataSource ds;

    //2、初始化连接池
    static {
        ds = new DruidDataSource();
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setUrl("jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        ds.setMaxActive(30);//最大连接数
        ds.setInitialSize(5);//初始连接数
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
