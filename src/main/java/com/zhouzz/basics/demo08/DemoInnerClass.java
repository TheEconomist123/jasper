package com.zhouzz.basics.demo08;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 17:13
 * @desc 一个事物里面包含另一个事物， 就像一个类里面还有一个类，属于包含关系   类似人体与心脏关系   汽车跟发动机
 * <p>
 * 分类
 * 1.成员内部类 :内用外随意用
 * 2.局部内部类
 */
public class DemoInnerClass {
    public static void main(String[] args) {
        Body body = new Body();
        body.methodBody();
        System.out.println("===================直接访问内部类方法============================");


        //直接调用 new Wai().new Nei().method();
        Body.Hear hear = new Body().new Hear();
         hear.beat();
    }
}
