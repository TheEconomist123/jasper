package com.zhouzz.basics.demo10.apply3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 21:09
 * @desc
 */
public class MyThread extends Thread {
    static int ticket = 0;
    //因为MyThread new 了三次
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket < 100) {
                    ticket++;
                    Thread.sleep(10);
                    System.out.println(getName() + "正在出售第:" + ticket + "张票！！");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //不管程序如何，最后这个代码都会执行。
                lock.unlock();
            }
        }
    }
}
