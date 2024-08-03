package com.zhouzz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/2 周五
 * @time 15:14 获取构造方法
 * @desc
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取所有的public 构造方法
        Class clazz = Class.forName("com.zhouzz.reflect.Student");
        Constructor[] cons = clazz.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("----------------------------------------------------");
        //获取所有declare 构造方法 
        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor constructor : cons2) {
            System.out.println(constructor);
        }
        System.out.println("----------------------------------------------------");
        Constructor decons = clazz.getDeclaredConstructor();
        System.out.println(decons);
        System.out.println("----------------------------------------------------");
        Constructor deconParams = clazz.getDeclaredConstructor(int.class);
        System.out.println(deconParams);
        System.out.println("------------------------------------------------");
        Constructor  consdec1 = clazz.getDeclaredConstructor(String.class, String.class);
        System.out.println(consdec1.getModifiers());
        System.out.println(consdec1);
        Parameter[] parameters = consdec1.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        System.out.println("-------------------利用私有构造的去创造对象-------------------");
        consdec1.setAccessible(true);
        Student stu =(Student) consdec1.newInstance("李思", "暴力使用私有构造创建对象");
        stu.setId(100);
        stu.setName("小明");
        System.out.println(stu);
    }
}
