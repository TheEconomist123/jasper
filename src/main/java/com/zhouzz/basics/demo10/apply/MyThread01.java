package com.zhouzz.basics.demo10.apply;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 22:43
 * @desc
 */
public class MyThread01 {
    public static void main(String[] args) {

        System.out.println("多线程测试开始。。。。。。。。。。。。。");
        MyRun m1 = new MyRun();
        MyRun m2 = new MyRun();
        Thread t1 = new Thread(m1, "坦克");
        Thread t2 = new Thread(m2, "飞机");
        t1.setPriority(1);
        t2.setPriority(10);
        Thread.currentThread().setPriority(1);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+"____"+Thread.currentThread().getPriority());
        System.out.println("多线程测试结束。。。。。。。。。。。。。");
    }
}
