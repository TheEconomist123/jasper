package com.zhouzz.reflect.adhibiton2;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 9:56
 * @desc
 */
public class MyRefectionDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(".\\prop.properties");
        pro.load(fis);
        fis.close();
        System.out.println(pro);
        /*System.out.println(System.getProperty("user.dir"));*/
        String className = (String) pro.get("className");
        String methodName = (String) pro.get("methodName");
        Class<?> clazz = Class.forName(className);
        //获取构造方法
        Constructor<?> cons = clazz.getDeclaredConstructor();
        Student o = (Student) cons.newInstance();
        System.out.println(o);
        //调用对应方法
        Method declaredMethod = clazz.getDeclaredMethod("study",String.class);
        declaredMethod.setAccessible(true);
        String str  = (String) declaredMethod.invoke( o,"周政之");
        System.out.println(str);

    }
}
