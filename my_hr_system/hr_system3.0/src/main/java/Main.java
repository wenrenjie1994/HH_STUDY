import service.MySQLUtil;
import service.ResumeService;

/**
 * @Author: chenlei
 * @Date: 2020/7/15 14:43
 */
public class Main {
    public static void main(String[] args) {
        ResumeService service = new ResumeService();
        service.run();
    }
}
