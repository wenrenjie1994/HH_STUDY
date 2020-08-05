package CommonClass.Compare;

/**
 * @Description 正常情况下，Java中只能比较== 或 !=，不能使用> 、< ；
 *      如何比较两个对象的大小，使用两个接口：Comparable或Comparator
 * @author liuclo
 * @date 2020/8/5 10:40
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {
    //Comparable：自然排序
    //String、包装类实现了Comparable接口，重写了compareTo()方法，比较两个对象大小
    @Test
    public void test1() {
        String[] arr = new String[]{"dd", "aa", "yy", "cc", "dd", "gg", "mm", "jj"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("xiaomi", 59, 200);
        arr[1] = new Goods("HUAWEI", 99, 180);
        arr[2] = new Goods("OV", 99, 79);
        arr[3] = new Goods("apple", 299, 800);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Comparator：定制排序
    @Test
    public void test3() {
        String[] arr = new String[]{"dd", "aa", "yy", "cc", "dd", "gg", "mm", "jj"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("传入数据不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[5];

        arr[0] = new Goods("xiaomi", 79, 200);
        arr[1] = new Goods("HUAWEI", 99, 180);
        arr[2] = new Goods("OV", 99, 80);
        arr[3] = new Goods("apple", 199, 800);
        arr[4] = new Goods("Sang", 99, 80);

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods goods1 = (Goods)o1;
                    Goods goods2 = (Goods)o2;
                    if (goods1.getPrice() == goods2.getPrice()) {
                        if (goods1.getComments() == goods2.getComments()) {
//                            return compare(goods1.getName(), goods2.getName());
                            return goods1.getName().compareTo(goods2.getName());
                        } else {
                            return -Integer.compare(goods1.getComments(), goods2.getComments());
                        }
                    } else {
                        return -Double.compare(goods1.getPrice(), goods2.getPrice());
                    }
                }
                throw new RuntimeException("数据传输不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}

class Goods implements Comparable {
    private String name;
    private double price;
    private int comments;

    public Goods() {
    }

    public Goods(String name, double price, int comments) {
        this.name = name;
        this.price = price;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + ", price: " + price +
                ", comments: " + comments + "}";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            //return Double.compare(this.price, goods.price);
            Goods goods = (Goods)o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return -Integer.compare(this.comments, ((Goods) o).comments);
            }
        }
        throw new RuntimeException("传入的数据不一致");
    }
}
