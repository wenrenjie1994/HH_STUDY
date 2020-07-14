package Middle_Exception.SelfDefineException;

/**
 * @Author lee
 * @Date 2020/6/12 8:06 AM
 * 抛出自定义异常
 **/


public class Hero {
    //变量声明
    public String name;
    protected float hp;

    //自定义异常创建
    class EnemyHeroIsDeadException extends Exception{
        public EnemyHeroIsDeadException(){

        }
        public EnemyHeroIsDeadException(String msg){
            super(msg);
        }
    }

    //方法中抛出异常
    public void attackHero(Hero h) throws EnemyHeroIsDeadException{
        if(h.hp==0){
            //不处理，继续用throw抛出
            //使用了自定义异常的第二个构造方法
            throw new EnemyHeroIsDeadException(h.name+"已经挂了，不需要再释放技能");
        }
    }

    public static void main(String[] args) {
        Hero galen = new Hero();
        galen.name = "盖伦";
        galen.hp = 616;

        Hero timo = new Hero();
        timo.name = "提莫";
        timo.hp = 0;

        try{
            galen.attackHero(timo);
        }
        catch (EnemyHeroIsDeadException e){
            System.out.println("具体原因:"+e.getMessage());
            e.printStackTrace();
        }


    }
}
