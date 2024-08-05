package com.zhouzz.basics.demo06;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 8:32
 * @desc
 */
public class MyIntefaceDefaultBImpl implements MyIntefaceDefault {

    @Override
    public void show() {
        System.out.println("实现类B 重新接口方法");
    }

    @Override
    public void showNew() {
        System.out.println("B重写升级后的的方法........");
    }


}
