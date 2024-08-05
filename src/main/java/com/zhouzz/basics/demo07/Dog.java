package com.zhouzz.basics.demo07;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 15:49
 * @desc
 */
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void watchDoor(){
        System.out.println("狗看大门......................");
    }
}
