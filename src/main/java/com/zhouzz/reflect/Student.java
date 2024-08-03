package com.zhouzz.reflect;

import java.io.IOException;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/2 周五
 * @time 13:53
 * @desc
 */
public class Student {
    public int id;
    private String name;
    private int age;
    private String gender;
    private String desc; 

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    protected Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String gender, String desc) {
        this.gender = gender;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }


    private String  eat(String  ss) throws IOException ,NullPointerException,ClassCastException {
        System.out.println(ss+"正在吃早饭.......................!");

        return  ss;
    }
}
