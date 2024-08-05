package com.zhouzz.basics.demo06;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 8:31
 * @desc
 */
public interface MyIntefaceDefault {
    //常量  必须被赋值,命名规则大写
    int NUM = 10;

    void show();

    default void showNew() {
        System.out.println("这是接口升级后，接口自带方法.............");
    }

    static void showStatic() {
        System.out.println("这是接口中的静态方法");
    }
    // 只有jdk9中才允许接口含有普通私有方法跟私有静态方法。

  /*  private  void  showPrivate(){

    }*/
}
