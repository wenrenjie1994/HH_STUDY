package BasicContents.ClassAndObject;

/*
LOL中的英雄类
*/

public class Hero {
    String name;  // 英雄名字
    float hp;  // 血量
    float armor;  // 护甲
    int moveSpeed;  // 移动速度

    // 每个英雄都有坑的时候，定义名为坑的方法
    void keng() {
        System.out.println("坑队友！");
    }

    // 获取英雄的护甲值
    float getArmor() {
        return armor;
    }

    // 增加英雄的移动速度
    void addSpeed(int speed) {
        this.moveSpeed += speed;
    }

    public static void main(String[] args) {
        Hero zed = new Hero();
        zed.name = "zed";
        zed.hp = 520;
        zed.armor = 34.2f;
        zed.moveSpeed = 320;

        zed.addSpeed(40);
        System.out.println("当前的移动速度是：" + zed.moveSpeed);
        System.out.println("当前的护甲值是：" + zed.getArmor());
    }
}