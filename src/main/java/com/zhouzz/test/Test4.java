package com.zhouzz.test;

import java.io.File;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/14 周二
 * @time 10:25
 * @desc
 */
public class Test4 {
    public static void main(String[] args) {
        File file = new File("c1:\\");
        System.out.println(file.isDirectory());

        if (file.exists()) {
            System.out.println("文件存在！");
        }

    }
}
