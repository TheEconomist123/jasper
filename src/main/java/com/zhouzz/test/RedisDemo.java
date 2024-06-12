package com.zhouzz.test;

import com.alibaba.fastjson.JSONObject;
import com.zhouzz.pojo.CommonResp;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.CookieManager;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/29 周三
 * @time 10:31
 * @desc
 */
public class RedisDemo {
    public static void main(String[] args) {
        String ccc = "{\"phoneNumbers\":[{\"type\":\"home\",\"number\":\"123-456-7890\"},{\"type\":\"work\",\"number\":\"098-765-4321\"}],\"retCode\":\"00000\",\"retMsg\":\"ccc\"}";
        JSONObject object1 = JSONObject.parseObject(ccc);
        System.out.println(object1.get("phoneNumbers").toString());
        CommonResp commonResp = new CommonResp();
        /*tring value = "{\"library\":\"[{\\\"year\\\":1960,\\\"author\\\":\\\"Harper Lee\\\",\\\"genre\\\":\\\"Fiction\\\",\\\"title\\\":\\\"To Kill a Mockingbird\\\"},{\\\"year\\\":1949,\\\"author\\\":\\\"George Orwell\\\",\\\"genre\\\":\\\"Dystopian\\\",\\\"title\\\":\\\"1984\\\"},{\\\"year\\\":1813,\\\"author\\\":\\\"Jane Austen\\\",\\\"genre\\\":\\\"Romance\\\",\\\"title\\\":\\\"Pride and Prejudice\\\"},{\\\"year\\\":1925,\\\"author\\\":\\\"F. Scott Fitzgerald\\\",\\\"genre\\\":\\\"Tragedy\\\",\\\"title\\\":\\\"The Great Gatsby\\\"}]\",\"retCode\":\"000000\",\"retMsg\":\"调用成功\"}";
        commonResp.setRestCode("00000");
        commonResp.setRestMsg("cccc");
        JSONObject object = new JSONObject();
        Object list = object.put("list", value);

        commonResp.setRetData(object);
        System.out.println(commonResp.getRetData().toString());*/
    }
}
