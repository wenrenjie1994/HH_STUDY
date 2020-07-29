package demo06;

public class DemoGame {
    public static void main(String[] args) {
        //创建一个英雄角色
        Hero hero=new Hero();
        hero.setName("艾希");
        //一，使用实现类设置英雄技能
        //hero.setSkill(new Skillimpl());
        //二、使用内部类设置英雄技能
        /*Skill skill =new Skill(){
            public void use(){
                System.out.println("Biu~Biu~Biu~");
            }
        };
        hero.setSkill(skill);*/

        //使用匿名对象设置英雄技能
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("Biu~Biu~Biu~");
            }
        });

        hero.attak();

    }
}
