package com.zhouzz.basics.demo10.apply;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 22:42
 * @desc
 */
public class MyRun  implements  Runnable{
    @Override
    public void run() {

            System.out.println(Thread.currentThread().getName()+"@");


    }
}
