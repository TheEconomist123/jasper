package com.zhouzz.basics.demo10.apply3;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 21:09
 * @desc
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        m1.setName("窗口1");
        m2.setName("窗口2");
        m3.setName("窗口3");
        m1.start();
        m2.start();
        m3.start();
    }
}
