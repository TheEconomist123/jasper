package com.zhouzz.basics.demo09;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/8/4 周日
 * @time 22:41
 * @desc  测试接口作为成员变量类型
 */
public class Hero {

    //类作为一成员变量类型
    private String name;

    private  Skill  skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public  void  attack(){
        System.out.println("开始释放技能");
       this.skill.use();
        System.out.println("释放技能结束");


    }


}
