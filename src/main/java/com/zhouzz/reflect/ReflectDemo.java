package com.zhouzz.reflect;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/2 周五
 * @time 13:56
 * @desc
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 获取字节码文件对象的三种方法
         *1.Class.forName("全类名")
         *2.类名.class
         *3.对象.getClass
         */
        //第一种 //最常用
        Class clazz1 = Class.forName("com.zhouzz.reflect.Student");
        System.out.println(clazz1);
        //第二种  常用与参数进行传递
        Class clazz2 = Student.class;
        System.out.println(clazz1==clazz2);
        //第三种  需要获取得知文件对象才行。
        Student student = new Student();
        Class clazz3 = student.getClass();
        System.out.println(clazz2==clazz3);




    }
}
