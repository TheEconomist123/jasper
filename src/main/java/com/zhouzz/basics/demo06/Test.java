package com.zhouzz.basics.demo06;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 8:34
 * @desc  jdk8 可以定义默认方法，可以方便接口升级
 */
public class Test {
    public static void main(String[] args) {
        MyIntefaceDefaultAImpl defaultA = new MyIntefaceDefaultAImpl();
        defaultA.show();
        defaultA.showNew();
        System.out.println("=============================================================");
        MyIntefaceDefaultBImpl defaultB = new MyIntefaceDefaultBImpl();
        defaultB.show();
        defaultB.showNew();

        System.out.println("=============================================================");
        //静态方法跟对象没关系，所以不可以通过子类实现类对象去调用，它跟类有关，直接接口名称调用方法名即可
        MyIntefaceDefault.showStatic();
        System.out.println("============================接口中的常量必须被赋值且不可以更改值================================");
        System.out.println(MyIntefaceDefault.NUM);
    }
}
