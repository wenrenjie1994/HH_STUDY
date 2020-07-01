package com.spdb.resume;

import com.spdb.resume.pojo.Resume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ResumeApplication {


    private ArrayList<Resume> resumes;

    public  void setResumes(ArrayList<Resume> resumes) {
        this.resumes = resumes;
    }

    public  ArrayList<Resume> getResumes() {
        return resumes;
    }

    public static void main(String[] args) {

        SpringApplication.run(ResumeApplication.class, args);





    }

}
