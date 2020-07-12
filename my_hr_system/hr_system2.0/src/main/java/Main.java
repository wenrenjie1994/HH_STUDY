import model.Resume;
import service.FileService;
import service.ResumeService;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: chenlei
 * @Date: 2020/7/12 18:27
 */
public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        ResumeService resumeService = new ResumeService(fileService);
        resumeService.run();
    }
}
