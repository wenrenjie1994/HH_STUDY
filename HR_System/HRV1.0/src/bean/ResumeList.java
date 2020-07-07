package bean;
import java.util.LinkedList;
public class ResumeList {
    private static LinkedList<Resume> resumeList = new LinkedList<Resume>();

    public static LinkedList<Resume> getResumeList() {
        return resumeList;
    }
}
