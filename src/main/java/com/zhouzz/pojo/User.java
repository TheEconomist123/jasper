package com.zhouzz.pojo;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/15 周三
 * @time 22:50
 * @desc
 */
public class User {

    private int uid;
    private String name;
    private  int age;
    private String desc;

    public User() {
    }

    public User(int uid, String name, int age, String desc) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}
