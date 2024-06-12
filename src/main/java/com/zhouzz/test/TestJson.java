package com.zhouzz.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/29 周三
 * @time 17:09
 * @desc
 */
public class TestJson {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray list = new JSONArray();
        JSONObject listItem = new JSONObject();
        listItem.put("zzz","1212");
        listItem.put("uuu","1212");
        listItem.put("ccc","1212");
        listItem.put("bbb","1212");

        JSONObject listItem1 = new JSONObject();
        listItem1.put("zzz","1212");
        listItem1.put("uuu","1212");
        listItem1.put("ccc","1212");
        listItem1.put("bbb","1212");
        list.add(listItem);
        list.add(listItem1);
        jsonObject.put("list",list);
        System.out.println(jsonObject);

    }
}
