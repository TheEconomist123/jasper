package com.zhouzz.basics.demo07;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 15:52
 * @desc 向下转型一定要进行 instanceof 判断   否则会出现  ClassCastException
 */
public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();
        System.out.println("------------------------测试向下转型-------------------------------");
        if (a instanceof Cat) {
            ((Cat) a).catchMouse();
        }
        if (a instanceof Dog) {
            ((Dog) a).watchDoor();
        }
        //只要保证有唯一一次赋值即可
        final int cc;
        cc = 10;
    }
}
