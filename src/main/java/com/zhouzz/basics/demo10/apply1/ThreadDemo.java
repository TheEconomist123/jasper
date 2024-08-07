package com.zhouzz.basics.demo10.apply1;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 9:14
 * @desc
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
