package util;

import model.Resume;


public class Protocol {

    public String addResumeMessage(Resume resume) {
        return String.format("add:%s,%s,%s", resume.getName(), resume.getId(), resume.getSchool());
    }

    public String deleteResumeMessage(Resume resume) {
        return String.format("delete:%s", resume.getName());
    }

    public String updateResumeMessage(Resume oldResume, Resume newResume) {
        return String.format("update:%s,%s,%s,%s", oldResume.getName(), newResume.getName(),
                newResume.getId(), newResume.getSchool());
    }

    public String searchResumeMessage(Resume resume) {
        return String.format("search:%s", resume.getName());
    }
}
