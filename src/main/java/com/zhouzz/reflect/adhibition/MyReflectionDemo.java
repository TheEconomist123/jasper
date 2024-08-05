package com.zhouzz.reflect.adhibition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 9:36
 * @desc  将对象里面属性写入到文本文件中
 */
public class MyReflectionDemo {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Student s = new Student("小A", 23, "女", 167.5, "睡觉");
        Teacher t = new Teacher("波妞", 10000);
        saveObjects(t);
    }

    private static void saveObjects(Object obj) throws IllegalAccessException, IOException {
        //创建io流
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\develop\\code\\jasper\\src\\main\\resources\\reflect.txt"));
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}
