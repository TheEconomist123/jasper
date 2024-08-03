package com.zhouzz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.SocketTimeoutException;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/3 周六
 * @time 9:07
 * @desc
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("com.zhouzz.reflect.Student");
        //获取自己以及父类的公共方法
        Method[] declaredMethods = clazz.getMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("--------------------------------------------------");
        Method[] declaredMethods1 = clazz.getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println(method);
        }
        System.out.println("--------------------------------------------------");
        Method method = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(method.getModifiers());
        System.out.println(method);
        System.out.println(method.getName());
        for (Parameter parameter : method.getParameters()) {
            System.out.println(parameter);
        }
        System.out.println("-------------------获取方法抛出的异常-------------------");
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }
        //方法运行
         method.setAccessible(true);
        Student student = new Student();
        String str = (String) method.invoke(student, "汉堡");
        System.out.println(str);
    }
}
