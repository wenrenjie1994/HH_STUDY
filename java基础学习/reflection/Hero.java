package reflection;

/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 16:22 2020/5/22
 * @Modified By:
 */
public class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;

    static String copyright;

    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }
}

