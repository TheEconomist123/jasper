package com.zhouzz.basics.demo08;

import java.security.PublicKey;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 17:36
 * @desc 局部内部类  ：定义在一个方法内部的类，只有当前所属的犯法可以使用它，出了这个方法就用不了
 */
 public   class Wai {

     public   int num=20;
    public void methodOuter() {
        class Nei {
            final int num = 10;

            public void method() {
                System.out.println(num);
                System.out.println( new Wai().num);
            }
        }
        Nei nei = new Nei();
        nei.method();
    }
}
