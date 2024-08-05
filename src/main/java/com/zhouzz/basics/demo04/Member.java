package com.zhouzz.basics.demo04;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 22:51
 * @desc
 */
public class Member extends User {
    public Member() {
    }

    public Member(String name, Integer money) {
        super(name, money);
    }
    public void redWars(ArrayList<Integer> arrayList) {
        int index = new Random().nextInt(arrayList.size());
        Integer money = super.getMoney();
        Integer delta = arrayList.remove(index);
        super.setMoney(money + delta);
    }
}
