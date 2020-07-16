package util;

import bean.Operation;
import bean.Resume;

public class Parser {

    public Parser() {
    }

    public Operation<Resume> parseOperation(String message) {
        Operation<Resume> resumeOperation;

        String operation = message.split("/")[0];
        if ("queryAll".equals(operation)) {
            resumeOperation = new Operation<>(operation);
        } else if ("query".equals(operation) || "delete".equals(operation)) {
            String[] properties = message.split("/")[1].split(",");
            Resume resume = new Resume();
            resume.setName(properties[0]);
            resumeOperation = new Operation<>(operation, resume);
        } else {
            String[] properties = message.split("/")[1].split(",");
            Resume resume = new Resume();
            resume.setName(properties[0]);
            resume.setId(properties[1]);
            resume.setSchool(properties[2]);
            resumeOperation = new Operation<>(operation, resume);
        }


        return resumeOperation;
    }
}
