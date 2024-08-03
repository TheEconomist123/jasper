package com.zhouzz.interview;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/2 周五
 * @time 9:23
 * @desc 测试动态代理
 */
public class Test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.createProxy(bigStar);
        String result = proxy.sing("你太美！");
        System.out.println(result);
    }
}
