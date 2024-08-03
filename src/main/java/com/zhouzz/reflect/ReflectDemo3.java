package com.zhouzz.reflect;

import java.lang.reflect.Field;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 8:45
 * @desc 获取成员变量
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("com.zhouzz.reflect.Student");
        //获取成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("----------------------------------------------");
        //获取单个成员变量
        Field gender = clazz.getDeclaredField("gender");
        System.out.println(gender);
        System.out.println(gender.getType());
        System.out.println(gender.getModifiers());
        System.out.println(clazz.getModifiers());
        System.out.println("----------------------------------------");
        //获取变量中记录的值
        Student student = new Student("男", "小明");
        gender.setAccessible(true);
        String value = (String) gender.get(student);
        System.out.println(value);
        //修改对象里面的值
        gender.set(student, "李四");
        System.out.println(student.getGender());
    }
}
