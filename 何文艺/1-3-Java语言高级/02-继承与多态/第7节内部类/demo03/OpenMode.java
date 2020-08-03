package day0802.innerClass.demo03;

import java.util.ArrayList;

/*
塞钱进红包：只关注将钱塞进红包即可，不关心平均分配还是随机分配
totalMoney：要塞进红包的总金额
totalCount：红包的个数
 */
public interface OpenMode {
    public abstract ArrayList<Integer> divide(int totalMoney, int totalCount);
}
