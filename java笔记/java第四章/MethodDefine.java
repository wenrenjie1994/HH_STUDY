package basic.method.demo1;

public class MethodDefine {
    public static void main(String[] args) {
        sum(10,20);
        System.out.println(sum(10,20));
        System.out.println("==========");
        int num=sum(5,6);
        System.out.println("num="+num);
        System.out.println("==========");
        System.out.println(same(2,1));
        System.out.println("===============");
        System.out.println(sum100());
    }

    public static int sum(int a ,int b){
        int result = a+b;
        return result;
    }
    public static boolean same(int a,int b){
        boolean c;
        if(a==b){
            c= true;}
            else{
                c=false;
            }
            return c;
        }
        public static int sum100(){
            int a=0;
            for (int i = 0; i < 100; i++) {
                a+=i;
            }
            return a;
        }
    }

