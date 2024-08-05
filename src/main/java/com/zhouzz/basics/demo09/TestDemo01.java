package com.zhouzz.basics.demo09;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 22:47
 * @desc
 */
public class TestDemo01 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("艾西客");

        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("使用加特林扫射对面..............");
            }
        });
        hero.attack();
    }
}
