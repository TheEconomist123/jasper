package com.zhouzz.basics.demo04;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 22:50
 * @desc
 */
public class User {


    private String name;

    private Integer money;

    public User() {
    }

    public User(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public  void show(){
        System.out.println(name+"：账户余额为："+money);
    }
}
