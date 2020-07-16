package util;

import model.Resume;

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
}
