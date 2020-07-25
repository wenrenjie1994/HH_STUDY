package system;

import client.client;

public class Main {

    public static void main(String[] args) {
        // write your code here

        client client1 = new client();
        while (true) {
            int max = client1.printWelcome();
            int num = client1.inputNum(max);

            if (client1.choose(num)) {
                break;
            }

        }

    }
}
