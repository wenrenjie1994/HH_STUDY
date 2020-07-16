package util;

import model.Resume;

/**
 * 协议类，对传入的操作和对象进行封装
 * 封装为字符串信息
 * 在客户端中转化为字节流向服务器发送
 */
public class Protocol implements BaseOperation<Resume> {
    @Override
    public String add(Resume resume) {
        return "add/" + resume.toString();
    }

    @Override
    public String delete(Resume resume) {
        return "delete/" + resume.toString();
    }

    @Override
    public String update(Resume resume) {
        return "update/" + resume.toString();
    }

    @Override
    public String queryAll() {
        return "queryAll/resume";
    }

    @Override
    public String query(Resume resume) {
        return "query/" + resume.toString();
    }

    @Override
    public String quit() {
        return "quit";
    }
}
