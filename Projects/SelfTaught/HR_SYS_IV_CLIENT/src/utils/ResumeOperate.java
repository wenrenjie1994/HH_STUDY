package utils;

import bean.Response;
import bean.Resume;
import interaction.Parser;
import interaction.Protocol;
import net.Client;

import java.io.IOException;

public class ResumeOperate {
    private Client client;

    public ResumeOperate() {
        client = new Client();
    }

    /**
     * 添加简历
     *
     * @param resume
     * @return
     * @throws IOException
     */
    public Response addResume(Resume resume) throws IOException {
        return new Parser().parseAdd(client.sendMessageToServer(new Protocol().addResumeMessage(resume)));
    }

    /**
     * 删除简历
     *
     * @param resume
     * @return
     * @throws IOException
     */
    public Response deleteResume(Resume resume) throws IOException {
        return new Parser().parseDelete(client.sendMessageToServer(new Protocol().deleteResumeMessage(resume)));
    }

    /**
     * 更新简历
     *
     * @param newResume
     * @param oldResume
     * @return
     * @throws IOException
     */
    public Response updateResume(Resume newResume, Resume oldResume) throws IOException {
        return new Parser().parseUpdate(client.sendMessageToServer(new Protocol().updateResumeMessage(newResume, oldResume)));
    }

    /**
     * 查找简历（通过姓名）
     *
     * @param resume
     * @return
     * @throws IOException
     */
    public Response searchResumeByName(Resume resume) throws IOException {
        return new Parser().parseSearch(client.sendMessageToServer(new Protocol().searchResumeByNameMessage(resume)));
    }

    /**
     * 查找简历（通过身份证号）
     *
     * @param resume
     * @return
     * @throws IOException
     */
    public Response searchResumeById(Resume resume) throws IOException {
        return new Parser().parseSearch(client.sendMessageToServer(new Protocol().searchResumeByIdMessage(resume)));
    }

    /**
     * 关闭连接
     *
     * @param str
     * @throws IOException
     */
    public void closeNet(String str) throws IOException {
        client.sendMessageToServer(str);
        client.closeClient();
    }
}
