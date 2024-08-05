package com.zhouzz.basics.demo10;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 21:26
 * @desc 第二种启动线程的方式
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        //
        MyRun myRun = new MyRun();
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        t1.setName("线程1");
        t2.setName("线程2");
        //开启线程
        t1.start();
        t2.start();
    }
}
