package com.zhouzz.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/11 周六
 * @time 15:19
 * @desc
 */
public class Test1 {
    public static void main(String[] args) {

        String value="{\"retCode\":\"000000\",\"retMsg\":\"调用成功\",\"retData\":{\"library\":[{\"year\":1960,\"author\":\"Harper Lee\",\"genre\":\"Fiction\",\"title\":\"To Kill a Mockingbird\"},{\"year\":1949,\"author\":\"George Orwell\",\"genre\":\"Dystopian\",\"title\":\"1984\"},{\"year\":1813,\"author\":\"Jane Austen\",\"genre\":\"Romance\",\"title\":\"Pride and Prejudice\"},{\"year\":1925,\"author\":\"F. Scott Fitzgerald\",\"genre\":\"Tragedy\",\"title\":\"The Great Gatsby\"}]}}";
        JSONObject jsonObject = JSON.parseObject(value);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("retCode",jsonObject.get("retCode").toString());
        jsonObject1.put("retMsg",jsonObject.get("retMsg").toString());
        JSONObject  retData = (JSONObject) jsonObject.get("retData");
        jsonObject1.put("library",retData.get("library").toString());

      //  System.out.println(retData.get("library").toString());
        System.out.println(jsonObject1);
    }
}
