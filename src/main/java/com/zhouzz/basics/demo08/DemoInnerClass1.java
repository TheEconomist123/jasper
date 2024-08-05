package com.zhouzz.basics.demo08;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 17:34
 * @desc
 */
public class DemoInnerClass1 {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerMethod();
    }
}
