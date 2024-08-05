package com.zhouzz.basics.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 22:14
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        HaDog haDog = new HaDog();
        haDog.eat();
        haDog.sleep();
        System.out.println("==========================================================");
        JmDog jmDog = new JmDog();
        jmDog.sleep();
        System.out.println("==========================================================");
     /*   for (int i = 0; i <100 ; i++) {
            int c = new Random().nextInt(2);
            System.out.println(c);

        }*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int ccc=list.size();
        for (int i = 0; i < ccc; i++) {
            int c = new Random().nextInt(list.size());
            System.out.println(list.remove(c));
        }
    }
}
