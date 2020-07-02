package class_object.myenum;

//英雄联盟中有这么一些分类
//        TANK (坦克)
//        WIZARD (法师 )
//        ASSASSIN (刺客)
//        ASSIST (辅助)
//        设计一个枚举类型HeroType,使用上述分类作为常量
//
//        再编写一段switch语句，把每种枚举常量输出为中文字符串

public class SayType {
    public static void main(String[] args) {
        for (HeroType herotype : HeroType.values()) {
            System.out.println(herotype);

            switch (herotype) {
                case TANK:
                    System.out.println("坦克");
                    break;
                case WIZARD:
                    System.out.println("法师");
                    break;
                case ASSASSIN:
                    System.out.println("刺客");
                    break;
                case ASSIST:
                    System.out.println("辅助");
                    break;
            }
        }
    }
}
