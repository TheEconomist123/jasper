package com.zhouzz.basics.demo08;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 17:29
 * @desc
 */
public class Outer {
    private final int num = 10;

    public class Inner {
        int num = 20;

        public void innerMethod() {
            int num = 30;
            System.out.println(num);//就近原则
            System.out.println(this.num);//内部类的成员变量
            System.out.println(Outer.this.num);//外部类的成员变量

        }
    }
}
