package com.zhouzz.controller;

import com.zhouzz.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping ("/set")
    public String setValue(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return "Value set successfully";
    }

    @RequestMapping("/setWithExpire")
    public String setValueWithExpire(@RequestParam String key, @RequestParam String value,
                                     @RequestParam long timeout) {
        redisService.setValueWithExpire(key, value, timeout, TimeUnit.SECONDS);
        return "Value set with expiration successfully";
    }

    @RequestMapping("/get")
    public String getValue(@RequestParam String key) {
        return redisService.getValue(key);
    }

    @RequestMapping("/delete")
    public String deleteValue(@RequestParam String key) {
        redisService.deleteValue(key);
        return "Value deleted successfully";
    }
}
