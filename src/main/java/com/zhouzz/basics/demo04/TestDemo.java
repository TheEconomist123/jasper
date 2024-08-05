package com.zhouzz.basics.demo04;

import java.util.ArrayList;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 22:51
 * @desc
 */
public class TestDemo {
    public static void main(String[] args) {
        Manager manger = new Manager("群主", 100);
        Member m1 = new Member("用户A", 0);
        Member m2 = new Member("用户B", 0);
        Member m3 = new Member("用户C", 0);
        manger.show();
        m1.show();
        m2.show();
        m3.show();
        ArrayList<Integer> redList = manger.sendRedPacker(20, 3);
        System.out.println(redList);
        System.out.println("发完红包以后-----------------------------");
        m1.redWars(redList);
        m2.redWars(redList);
        m3.redWars(redList);
        manger.show();
        m1.show();
        m2.show();
        m3.show();
    }
}
