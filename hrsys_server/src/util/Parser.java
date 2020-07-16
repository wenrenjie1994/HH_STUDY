package util;

import bean.Operation;
import bean.Resume;

/**
 * 解析类，将客户端传来的消息封装为Operation类
 *
 * Todo 可与Client中的Protocol类合并打包成为协议工具包
 */
public class Parser {

    public Parser() {
    }

    /**
     * ‘/’前为操作类型，‘/’后为操作对象，
     * 此工程中操作对象同意为Resume对象
     * 各个属性由‘，’分开
     * @param message 客户端传入的消息
     * @return Operation对象，包含操作类型与操作对象
     */
    public Operation<Resume> parseOperation(String message) {
        Operation<Resume> resumeOperation;

        String operation = message.split("/")[0];
        if ("quit".equals(operation)) {
            resumeOperation = new Operation<>(operation);
        } else if ("queryAll".equals(operation)) {
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
