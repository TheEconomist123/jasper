package com.zhouzz.reflect.adhibiton2;


/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 14:33
 * @desc
 */
public class Student {
    private String name;

    public Student() {
    }



    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String study(String name) {
        System.out.println(name + "正在学习................");
        return name;
    }
}
