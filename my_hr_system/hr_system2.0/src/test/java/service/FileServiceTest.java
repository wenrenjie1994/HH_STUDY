package service;

import model.Resume;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: chenlei
 * @Date: 2020/7/12 21:05
 */
public class FileServiceTest {
    @Test
    public void writeFile(){
        FileService fileService = new FileService();
        LinkedList<Resume> resumeLinkedList = new LinkedList<Resume>();
        Resume resume1 = new Resume("a",1,"b");
        Resume resume2 = new Resume("b",2,"c");
        resumeLinkedList.add(resume1);
        resumeLinkedList.add(resume2);
        fileService.writeFile(resumeLinkedList);
    }

    @Test
    public void readFile() {
        FileService fileService = new FileService();
        LinkedList<Resume> resumeLinkedList = fileService.readFile();
        for(Resume resume : resumeLinkedList) {
            System.out.println(resume.toString());
        }
    }
}
