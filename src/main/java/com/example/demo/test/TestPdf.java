package com.example.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/14 周二
 * @time 15:41
 * @desc
 */
public class TestPdf {
    public static void main(String[] args) throws Exception {

        //
        System.out.println(getConnection());
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zzz", "root", "root");
        return connection;
    }
}
