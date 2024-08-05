package com.zhouzz.basics.demo09;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 22:27
 * @desc 匿名内部类的演示
 */
public class Test {
    public static void main(String[] args) {

        //这样可以省掉一个实现类的定义
        //往往应用与只能用一次， 匿名对象只能调用一次
        MyInterface myInterface = new MyInterface() {
            @Override
            public void show() {
                System.out.println("重写接口的方法");
            }
        };
        myInterface.show();
    }
}
