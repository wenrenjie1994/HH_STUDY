package net;

import bean.Request;
import bean.Response;
import bean.Resume;
import interaction.Parser;
import interaction.Protocol;
import utils.ResumeOperate;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.LinkedList;

public class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String str;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                str = in.readLine();
            } catch (Exception e) {
                System.out.println("客户端断开连接！");
                break;
            }
            Request request = new Parser().parseStr(str);
            Response response = new Response();
            if ("add".equals(request.getHead())) {
                LinkedList<Resume> resumes = (LinkedList<Resume>) request.getData();
                Resume resume = resumes.get(0);
                try {
                    response = new ResumeOperate().addResume(resume);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String message = new Protocol().addResumeMessage(response);
                System.out.println("向客户端返回：" + message);
                out.println(message);
            } else if ("delete".equals(request.getHead())) {
                LinkedList<Resume> resumes = (LinkedList<Resume>) request.getData();
                Resume resume = resumes.get(0);
                try {
                    response = new ResumeOperate().deleteResume(resume);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String message = new Protocol().deleteResumeMessage(response);
                System.out.println("向客户端返回：" + message);
                out.println(message);
            } else if ("update".equals(request.getHead())) {
                LinkedList<Resume> resumes = (LinkedList<Resume>) request.getData();
                Resume newResume = resumes.get(1);
                Resume oldResume = resumes.get(0);
                try {
                    response = new ResumeOperate().updateResume(newResume, oldResume);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String message = new Protocol().updateResumeMessage(response);
                System.out.println("向客户端返回：" + message);
                out.println(message);
            } else if ("searchByName".equals(request.getHead())) {
                LinkedList<Resume> resumes = (LinkedList<Resume>) request.getData();
                Resume resume = resumes.get(0);
                try {
                    response = new ResumeOperate().searchResumeByName(resume);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String message = new Protocol().searchResume(response);
                System.out.println("向客户端返回：" + message);
                out.println(message);
            } else if ("searchById".equals(request.getHead())) {
                LinkedList<Resume> resumes = (LinkedList<Resume>) request.getData();
                Resume resume = resumes.get(0);
                try {
                    response = new ResumeOperate().searchResumeById(resume);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String message = new Protocol().searchResume(response);
                System.out.println("向客户端返回：" + message);
                out.println(message);
            }
        }
    }
}
