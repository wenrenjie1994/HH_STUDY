package system;

import hr.hr;

public class Main {

    public static void main(String[] args) {
        // write your code here

        hr hr1 = new hr();
        while (true) {
            int max = hr1.printWelcome();
            int num = hr1.inputNum(max);
            hr1.choose(num);
        }

    }
}
