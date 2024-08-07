package com.zhouzz.basics.demo10;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 21:08
 * @desc 多线程第一种类启动方式
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
