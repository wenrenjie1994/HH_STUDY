package JavaDemo.Abstraction.Template;

public class TemplateTest {
    public static void main(String[] args) {
        Template template = new SubTemplate();
        template.spendTime();
    }
}

abstract class Template {
    public void spendTime() {
        long start = System.currentTimeMillis();

        //uncertain
        code();

        long end = System.currentTimeMillis();

        System.out.println("spend time!! " + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template {
    @Override
    public void code() {
        System.out.println("**********");
        int cnt = 0;
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                cnt++;
                System.out.print(i);
                if (cnt % 10 == 0) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n**********");
    }

    public boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return  false;
            }
        }
        return true;
    }
}
