package com.zhouzz.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/21 周二
 * @time 15:39
 * @desc
 */
public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        User user = new User(2,list);
        user.setId(20);
        List<String> list1 = user.getList();
        list1.set(0,"cccccc");
        List<String> list2 = user.getList();
        System.out.println(user.getId());
    }
}
