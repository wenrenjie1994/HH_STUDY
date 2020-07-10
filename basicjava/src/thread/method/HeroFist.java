package thread.method;

//英雄有可以放一个技能叫做: 波动拳-a du gen。
//        每隔一秒钟，可以发一次，但是只能连续发3次。
//
//        发完3次之后，需要充能5秒钟，充满，再继续发。
public class HeroFist {
    public static void main(String[] args) {
        int a = 0;
        while(true){
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.printf("波动拳第%d发%n",i+1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            a++;
            if(a==3)
                break;
            try {
                System.out.println("波动拳开始充能5s");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
