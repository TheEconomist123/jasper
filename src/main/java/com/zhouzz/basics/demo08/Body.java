package com.zhouzz.basics.demo08;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 17:16
 * @desc
 */
public class Body {

    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Hear {
        public void beat() {
            System.out.println("心脏蹦蹦跳");
            System.out.println("我叫:"+name);
        }
    }

    public void methodBody() {

        System.out.println("外部类方法..............");
        new Hear().beat();
    }
}
