package com.example.demo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/11 周六
 * @time 15:19
 * @desc
 */
public class Test1 {
    public static void main(String[] args) {

        String json = "{\"name\": \"John\", \"age\":[], \"city\": \"New York\"}";
        JSONArray read = (JSONArray) JSONPath.read(json, "$.age");
        System.out.println(read.size());
    }
}
