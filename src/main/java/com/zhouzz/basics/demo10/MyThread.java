package com.zhouzz.basics.demo10;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 21:10
 * @desc
 */
public class MyThread extends  Thread {

    @Override
    public  void run(){
        for (int i = 0; i <100 ; i++) {
            System.out.println("i:"+i);

        }
    }


}
