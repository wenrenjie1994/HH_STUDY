public class DoWhileLoop {
    Scanner scanner = new Scanner(System.in);
    String result = "";
do {
        System.out.println("张三考试");
        System.out.print("是否合格？y/n");
        result = scanner.next();
    }
while(result.equals("y"));
System.out.println("合格");
}
