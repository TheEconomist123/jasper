package com.zhouzz.basics.demo05;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 7:56
 * @desc
 */
public interface MyInterfaceAbstract {
    //抽象方法 必须有 public abstract  不写默认给你添加


   public abstract void methodA();

    abstract void methodB();

    void methodC();
}
