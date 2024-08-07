package com.zhouzz.basics.demo10.apply1;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 9:10
 * @desc
 */
public class MyThread extends Thread {
    //表示这个类的所有对象都共享这个ticket
    static int ticket = 0;
    //锁对象一定要唯一
    static Object obj = new Object();
    //一个类的字节码文件对象肯定是唯一的

    @Override
    public void run() {
        while (true) {
            //同步代码块  使得同步代码块里面的代码是轮流执行的。
            synchronized (MyThread.class) {
                if (ticket < 100) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + " 正在卖第" + ticket + "票");
                } else {
                    break;
                }
            }
        }
    }

/*
在面向对象编程中，‌子类继承父类的属性和方法。
‌如果父类的方法没有声明抛出任何异常，‌那么子类在重写该方法时，‌也不应该声明抛出异常。‌
这是因为，‌如果父类的方法被设计为不抛出异常，‌那么子类在实现这个方法时，‌如果抛出异常，
‌可能会让调用者产生混淆，‌不清楚这个异常是从父类方法中抛出的还是子类方法中抛出的。‌
此外，‌如果子类抛出了异常，‌而父类没有，‌这可能会违反面向对象设计原则中的《里氏替换原则》”，
‌即子类必须能够替换其父类而不会引起任何问题。‌
*/
}
