package com.zhouzz.basics.demo04;

import java.util.ArrayList;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 22:50
 * @desc
 */
public class Manager extends User {
    public Manager() {
    }

    //设置自己财产
    public Manager(String name, Integer money) {
        super(name, money);
    }
    //发送红包

    public ArrayList<Integer> sendRedPacker(Integer totalMoney, int nums) {
        ArrayList<Integer> redList = new ArrayList<>();
        Integer leftMoney = super.getMoney();
        if (leftMoney < totalMoney) {
            System.out.println("余额不足");
            return redList;
        }
        super.setMoney(leftMoney - totalMoney);
        //
        int avg = totalMoney / nums;
        int mod = totalMoney % nums;
        for (int i = 0; i < nums - 1; i++) {
            redList.add(avg);
        }
        int lastRed=avg+mod;
        redList.add(lastRed);
        return redList;
    }
}
