package com.zhouzz.basics.demo10.apply1;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/7 周三
 * @time 15:16
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        String cc = "/";
        StringUtils.isBlank(cc);
        System.out.println("ccc:" + cc);
        boolean blank = StringUtils.isBlank(cc);

        if (blank) {
            cc = "/";
        }
        System.out.println(cc);


    }
}
