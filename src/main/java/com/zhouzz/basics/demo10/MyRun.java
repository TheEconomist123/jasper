package com.zhouzz.basics.demo10;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 21:28
 * @desc
 */
public class MyRun  implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //当前线程对象
            Thread t = Thread.currentThread();
            System.out.println("线程：" + t.getName() + "___" + i);
        }
    }
}
