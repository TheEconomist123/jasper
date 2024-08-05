package com.zhouzz.basics.demo10.apply;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 22:32
 * @desc
 */
public class MyDemo01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("坦克");
        t2.setName("飞机");
        t1.start();
        t2.start();
        //jvm启动会默认开启多个线程，其中main线程就是执行里面的方法。
    }
}
