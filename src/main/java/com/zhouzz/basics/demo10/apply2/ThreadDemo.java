package com.zhouzz.basics.demo10.apply2;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 20:45
 * @desc
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread t1 = new Thread(myRun,"窗口1");
        Thread t2 = new Thread(myRun,"窗口2");
        Thread t3 = new Thread(myRun,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
