package com.zhouzz.basics.demo02;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 19:18
 * @desc
 */
public class Cat extends  Animal {
    public Cat() {
        System.out.println("子类构造方法");
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼。。。。。。。。。。。。。。。。。。。。。");
    }
}
