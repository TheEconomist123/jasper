package com.zhouzz.basics.demo10.apply2;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 20:40
 * @desc  测试同步方法，非静态方法锁对象是this
 */
public class MyRun implements Runnable {
    int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if (extracted()) break;
        }
    }

    //非静态锁是this 其实就是MyRun
    private synchronized boolean extracted() {
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在出售第" + ticket + "张票");
        }
        return false;
    }
}
