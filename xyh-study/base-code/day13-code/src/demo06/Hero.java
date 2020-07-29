package demo06;

import java.security.PublicKey;

public class Hero {
    private String  name;
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void attak(){
        System.out.println("我叫"+this.name+",开始释放技能");
        this.skill.use();
        System.out.println("技能释放结束");
    }
}
