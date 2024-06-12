package com.zhouzz.controller;

import ch.qos.logback.classic.db.names.ColumnName;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhouzz.pojo.CommonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/6/4 周二
 * @time 15:43
 * @desc
 */
@RestController
@RequestMapping("/json")
public class JsonController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/getData")
    public CommonResp getData() {
        String ccc = "{\"phoneNumbers\":[{\"type\":\"home\",\"number\":\"123-456-7890\"},{\"type\":\"work\",\"number\":\"098-765-4321\"}],\"retCode\":\"00000\",\"retMsg\":\"ccc\"}";
        JSONObject object1 = JSONObject.parseObject(ccc);
        String phoneNumbers = object1.get("phoneNumbers").toString();
        System.out.println("phoneNumbers:" + phoneNumbers);
        CommonResp commonResp = new CommonResp();
        Object o = redisTemplate.opsForValue().get("2222");
        if (null != o) {
            return getRedisCacheData(o);
        } else {
            //保存数据
            Map<String, String> map = new HashMap<>();
            map.put("list", phoneNumbers);
            commonResp.setRetData(map);
            commonResp.setRetMsg("cccc");
            commonResp.setRetCode("000000");
            redisTemplate.opsForValue().set("2222", commonResp, 1000L, TimeUnit.SECONDS);

            return getRedisCacheData(redisTemplate.opsForValue().get("2222"));
        }
    }

    public CommonResp getRedisCacheData(Object o) {
        JSONObject object1 = JSON.parseObject(o.toString());
        System.out.println(object1.getJSONObject("retData").get("list").toString());
        CommonResp commonResp = new CommonResp();
        Map map = (HashMap) o;
        System.out.println(map);
        commonResp.setRetData(map.get("retData"));
        Map retData = (HashMap) map.get("retData");
        String list = retData.get("list").toString();
        JSONArray objects = JSON.parseArray(list);
        JSONObject object = new JSONObject();
        object.put("list", objects);
        commonResp.setRetMsg(map.get("retCode").toString());
        commonResp.setRetCode(map.get("retCode").toString());
        commonResp.setRetData(object);
        return commonResp;
    }
}
