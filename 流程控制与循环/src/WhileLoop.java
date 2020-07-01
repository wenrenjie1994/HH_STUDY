public class WhileLoop {
    int num = 0;
    String flag = "y";
while(flag.equal("y")) {
        System.out.print("请输⼊学⽣学号：");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        switch(id) {
            case 1:
                System.out.println("张三的成绩是96");
                break;
            case 2:
                System.out.println("李四的成绩是91");
                break;
            case 3:
                System.out.println("王五的成绩是89");
                break;
            default:
                System.out.println("请输⼊正确的学号");
                break;
        }
        System.out.print("是否继续？y/n");
        flag = scanner.next();
    }
System.out.println("感谢使⽤学⽣成绩查询系统");
}
