package com.zhouzz.basics.demo05;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 8:02
 * @desc
 */
public class MyInterfaceAbstractImpl implements MyInterfaceAbstract {
    @Override
    public void methodA() {
        System.out.println("这是第一个方法");
    }

    @Override
    public void methodB() {
        System.out.println("这是第二个方法");
    }

    @Override
    public void methodC() {
        System.out.println("这是第三个方法");
    }
}
