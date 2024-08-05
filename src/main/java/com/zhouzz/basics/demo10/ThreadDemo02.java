package com.zhouzz.basics.demo10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 21:44
 * @desc 多线程启动第三种方式
 */
public class ThreadDemo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(mc);
        Thread t = new Thread(ft);

        t.start();
        Integer i = ft.get();
        System.out.println("多线程运行结果："+i);

    }
}
