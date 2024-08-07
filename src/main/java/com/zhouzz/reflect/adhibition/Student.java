package com.zhouzz.reflect.adhibition;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 9:38
 * @desc
 */
public class Student {

    private String name;
    private int  age;
    private String gender;
    private double  height;
    private String hobby;

    public Student() {
    }

    public Student(String name, int age, String gender, double height, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.hobby = hobby;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
