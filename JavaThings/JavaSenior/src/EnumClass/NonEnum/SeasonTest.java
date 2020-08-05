package EnumClass.NonEnum;

public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN.getDesc());
    }
}

class Season {
    //1. 声明属性是private final
    private final String Name;
    private final String Desc;

    //2. 私有化构造器，并给属性赋值
    private Season(String Name, String Desc) {
        this.Name = Name;
        this.Desc = Desc;
    }

    //3. 提供枚举类对象，声明为public static final
    public static final Season SPRING = new Season("春天", "百花齐放");
    public static final Season SUMMER = new Season("夏天", "映日荷花");
    public static final Season AUTUMN = new Season("秋天", "金色大地");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");

    //4. 其他诉求，获取枚举类对象的属性
    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    @Override
    public String toString() {
        return "Season{Name: " + Name + ", Desc: " + Desc + "}";
    }
}
