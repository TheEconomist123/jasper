package com.zhouzz.basics.demo07;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 15:50
 * @desc
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼.............");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠..............");
    }
}
