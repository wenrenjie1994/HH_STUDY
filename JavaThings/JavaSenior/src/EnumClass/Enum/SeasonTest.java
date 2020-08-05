package EnumClass.Enum;

public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN.getDesc());
        System.out.println(Season.class.getSuperclass());
    }
}

enum Season {
    //1. 提供枚举类对象，声明为public static final
    SPRING("春天", "百花齐放"),
    SUMMER("夏天", "映日荷花"),
    AUTUMN("秋天", "金色大地"),
    Season("冬天", "白雪皑皑");

    //2. 声明属性是private final
    private final String Name;
    private final String Desc;

    //3. 私有化构造器，并给属性赋值
    private Season(String Name, String Desc) {
        this.Name = Name;
        this.Desc = Desc;
    }

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

