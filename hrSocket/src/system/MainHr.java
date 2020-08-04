package system;

import client.clientHr;

public class MainHr {

    public static void main(String[] args) {
        // write your code here

        clientHr client1 = new clientHr();
        while (true) {
            int max = client1.printWelcome();
            int num = client1.inputNum(max);

            if (client1.choose(num)) {
                break;
            }

        }

    }
}
