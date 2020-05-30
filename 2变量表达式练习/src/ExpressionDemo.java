public class ExpressionDemo {
    public static void main(String[] args){
        int a = 2;
        int b,c,d,f,g,h;
        b = +a; //正值
        System.out.println("b="+b+",a="+a);//b=2 a=2 没有初始化默认为0
        c = -a; //负值 -2
        System.out.println("c="+c+",a="+a);//a=2
        int l = 2;
        d = ++l; //先l=l+1;再d=l
        System.out.println("d="+d+",l="+l);//d=3 l=3
        int m = 3;
        f = m++;//先f=m;再m=m+1
        System.out.println("f="+f+",m="+m);//f=3,m=4
        int n = 4;
        g = --n;//先n=n-1;再g=n
        System.out.println("g="+g+",n="+n);//g=3,n=3
        int o = 6;
        h = o--;//先h=o;再o=o-1
        System.out.println("h="+h+",o="+o);//h=6,o=5
    }
}
