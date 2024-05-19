package com.example.demo.test;

import java.math.BigDecimal;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/13 周一
 * @time 16:26
 * @desc
 */
public class Test3 {
    public static void main(String[] args) {

        BigDecimal b1 = new BigDecimal("0.345");
        BigDecimal b2 = new BigDecimal("0.346");
        System.out.println(b1.compareTo(b2)==-1);


        if(2>1){
            throw new RuntimeException("2214442142414");
        }

    }
}
