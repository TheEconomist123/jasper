package com.zhouzz.basics.demo10;

import java.util.concurrent.Callable;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/5 周一
 * @time 21:47
 * @desc
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        //求1-100之间和
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
