package com.zhouzz.interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/2 周五
 * @time 8:15
 * @desc 创建一个代理
 */
public class ProxyUtil {
    public static Star createProxy(BigStar bigStar) {
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),//指定那个类加载器，去加载生成代理类
                new Class[]{Star.class},//指定接口，接口里面方法就是代理的方法
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("sing".equals(method.getName())) {
                            System.out.println("唱歌之前先唱歌的钱。。。。。。。。。。。。。。");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("跳舞之前先收跳舞的钱...........");
                        }
                        return method.invoke(bigStar, args);
                    }
                }
        );
        return star;
    }
}
