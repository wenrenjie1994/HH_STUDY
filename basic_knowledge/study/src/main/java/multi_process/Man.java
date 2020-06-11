package multi_process;

import lombok.Data;

import java.util.Random;

/**
 * @author: chenlei
 * @date: 14:28 2020/6/11
 **/
@Data
public class Man{
    private String name;
    private Integer total;
    public Man(String name,Integer total) {
        this.name = name;
        this.total = total;
    }

    public void play() {
        this.total ++;
        System.out.println(name + ":" + total);
    }
}
