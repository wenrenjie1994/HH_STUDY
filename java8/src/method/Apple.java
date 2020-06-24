package method;

/**
 * @Author: A wei
 * @Date: 2020/6/23 17:51
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
public class Apple {

    private String color;

    private int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}
