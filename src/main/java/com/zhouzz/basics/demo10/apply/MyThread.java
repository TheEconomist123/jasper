package com.zhouzz.basics.demo10.apply;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 22:30
 * @desc
 */
public class MyThread  extends  Thread{

    @Override
    public  void run(){
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName()+"@"+i);
        }

    }
}
