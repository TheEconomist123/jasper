package com.zhouzz.interview;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/2 周五
 * @time 8:02
 * @desc
 */
public class BigStar implements Star {
    private String name;

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    //唱歌
    @Override
    public String sing(String name) {
        System.out.println(this.name + "正在唱歌"+name);
        return "谢谢";
    }

    @Override
    public void dance(String name) {
        System.out.println(this.name + "正在"+name+"舞蹈");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
