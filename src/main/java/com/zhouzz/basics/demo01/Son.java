package com.zhouzz.basics.demo01;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 15:36
 * @desc  记住子类必须调用父类构造方法 ，还有this() 跟super不可以同时在一起使用。
 */
public class Son extends Fu {


    private String name ;

    public Son() {

        this("小敏");
        System.out.println("ccccccc");
    }

    public Son(String name) {
       super("22222");
        System.out.println("name_____"+name);
    }
}
