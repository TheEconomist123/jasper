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

    }
}
