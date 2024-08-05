package com.zhouzz.reflect.adhibition;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 9:39
 * @desc
 */
public class Teacher {

    private String name;
    private int salary;

    public Teacher() {
    }

    public Teacher(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
