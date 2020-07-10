package com.pan.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //创建学院
        List<College> collegeList = new ArrayList<>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        Output output1 = new Output(collegeList);
        output1.printCollege();
    }
}
