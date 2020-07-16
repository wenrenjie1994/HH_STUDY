package sys;

import bean.Resume;
import utils.DBConnection;
import utils.ResumeOperate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;


public class HRS {
    public static void main(String[] args) {
        boolean isExitRequested = false;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("***** ��ӭ�����������ϵͳ *****");
            System.out.println("չʾ������0");
            System.out.println("��Ӽ�����1");
            System.out.println("ɾ��������2");
            System.out.println("�޸ļ�����3");
            System.out.println("��ѯ������4");
            System.out.println("�˳��밴��5");
            switch (sc.nextInt()) {
                case 0:
                    showResume();
                    break;
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    searchResume();
                    break;
                case 5:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("������������������");
            }
            if (isExitRequested) {
                break;
            }
        }
        sc.close();
        System.out.println("���˳���");
    }

    /**
     * չʾ����
     */
    private static void showResume() {
        LinkedList<Resume> resumes = new LinkedList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from resumes";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                r.setProcess(rs.getInt("process"));
                r.setDeleteStatus(rs.getInt("deleteStatus"));
                resumes.add(r);
            }
            DBConnection.closeConnection(rs, statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("����������ϵͳ����" + resumes.size() + "�ݼ�����");
        for (Resume resume : resumes) {
            System.out.println(resume);
        }
    }

    /**
     * ��Ӽ���
     */
    private static void addResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** ��Ӽ���(�������������������֤�š�ѧУ) *****");
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        Resume resume = new Resume(name, id, school);
        int line = new ResumeOperate().addResume(resume);
        if (line > 0) System.out.println("����ӣ�");
        else System.out.println("���ʧ�ܣ�");
    }

    /**
     * ɾ������
     */
    private static void deleteResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** ɾ������(���������֤��) *****");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        int line = new ResumeOperate().deleteResumeById(resume);
        if (line > 0) System.out.println("��ɾ����");
        else System.out.println("û���ҵ�����Ҫɾ���ļ�����");
    }

    /**
     * ���¼���
     */
    private static void updateResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** �޸ļ���(���������֤��) *****");
        String id = input.nextLine();
        Resume oldResume = new Resume(null, id, null);
        if (new ResumeOperate().searchResumeById(oldResume).size() > 0) {
            System.out.println("�ҵ�ԭ�����������������µ����������֤�š�ѧУ������״̬��");
            String newName = input.nextLine();
            String newID = input.nextLine();
            String newSchool = input.nextLine();
            int newProcess = input.nextInt();
            Resume newResume = new Resume(newName, newID, newSchool);
            newResume.setProcess(newProcess);
            new ResumeOperate().updateResumeById(newResume, oldResume);
        } else System.out.println("û���ҵ�����Ҫ�޸ĵļ�����");
    }

    /**
     * ���Ҽ���
     */
    private static void searchResume() {
        Scanner sc = new Scanner(System.in);
        boolean isExitRequested = false;
        while (true) {
            System.out.println("***** ���Ҽ���(���������ң�0�������֤�Ų��ң�1���˳���2) *****");
            switch (sc.nextInt()) {
                case 0:
                    searchResumeByName();
                    break;
                case 1:
                    searchResumeById();
                    break;
                case 2:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("������������������");
            }
            if (isExitRequested) {
                break;
            }
        }
        System.out.println("���˳���������ϵͳ��");
    }

    private static void searchResumeByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** ���Ҽ���(����������) *****");
        String name = input.nextLine();
        Resume resume = new Resume(name, null, null);
        LinkedList<Resume> resumes = new ResumeOperate().searchResumeByName(resume);
        if (resumes.size() > 0) {
            System.out.println("ͨ���������鵽" + resumes.size() + "�ݼ�����");
            for (Resume r : resumes) {
                System.out.println(r);
            }
        } else System.out.println("û�в��ҵ���Ӧ������");
    }

    private static void searchResumeById() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** ���Ҽ���(���������֤��) *****");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        LinkedList<Resume> resumes = new ResumeOperate().searchResumeById(resume);
        if (resumes.size() > 0) {
            System.out.println("ͨ�����֤�Ź��鵽" + resumes.size() + "�ݼ�����");
            for (Resume r : resumes) {
                System.out.println(r);
            }
        } else System.out.println("û�в��ҵ���Ӧ������");
    }
}
