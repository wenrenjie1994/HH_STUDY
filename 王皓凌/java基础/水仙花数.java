public class Test {
    public static void main(String[] args) {
        int i;
        for(i=100;i<1000;i++){
            if(i==shuixianhua(i)){
                System.out.println(i+'\n');
            }
        }

    }
    public static int lifang(int a){
        return a*a*a;
    }
    public static int shuixianhua(int a){
        int b;
        b=lifang(a/100)+lifang(((a/10)%10))+lifang((a%10));
        return b;
    }
}
