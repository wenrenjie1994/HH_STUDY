package com.spdb.study.design.pattern.bridge.course;

/**
 * 抽象桥梁
 * @author Mr.Longyx
 * @date 2020年07月06日 17:05
 */
public class AbstractCourse implements Course{
    private Note note;
    private Video video;

    public void setNote(Note note) {
        this.note = note;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "note=" + note +
                ", video=" + video +
                '}';
    }
}
