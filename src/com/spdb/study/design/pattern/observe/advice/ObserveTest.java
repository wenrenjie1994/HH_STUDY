package com.spdb.study.design.pattern.observe.advice;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 14:47
 */
public class ObserveTest {
    public static void main(String[] args) {
        GitHub gitHub = GitHub.getInstance();
        Teacher teacher = new Teacher("文老师");

        Issues issues = new Issues();
        issues.setUsername("Komi");
        issues.setContent("设计模式中的观察者模式具体适用于哪些场景呢？");

        gitHub.addObserver(teacher);
        gitHub.publishIssues(issues);

    }
}
