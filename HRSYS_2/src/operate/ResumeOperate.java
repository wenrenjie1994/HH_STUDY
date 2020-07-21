package operate;
import java.util.LinkedList;
import java.util.Scanner;

public class ResumeOperate {

	// 展示所有简历
    public static void showResume() {
    	LinkedList<Resume> resumes = new LinkedList<>();
    	DataOperate.loadData(resumes);
    	if (resumes.size() == 0) {
            System.out.println("HR系统为空");
            return;
        }
        System.out.println("HR系统中一共有" + resumes.size() + "份简历，" + "如下：");
        for (Resume resume : resumes) {
        	int k=resumes.indexOf(resume)+1;
        	System.out.println("*****第" + k + "份简历*****");
            System.out.println(resume);
        }
    }
    
    //查看指定简历状态的简历
    public static void showAppointResume() {
    	LinkedList<Resume> resumes = new LinkedList<>();
    	DataOperate.loadData(resumes);
    	if (resumes.size() == 0) {
            System.out.println("HR系统为空");
            return;
        }
    	Scanner sc=new Scanner(System.in);
    	boolean keepon=false;
    	do {
    		System.out.println("*****请输入要查询的简历状态*****");
        	System.out.println("-1：加入人才库");
        	System.out.println("0：已申请");
        	System.out.println("1：简历通过");
        	System.out.println("2：笔试通过");
        	System.out.println("3：面试通过");
        	System.out.println("4：体检通过");
        	System.out.println("5：背调通过");
        	System.out.println("6：已签约");
        	System.out.println("7：已入职");
        	int k = sc.nextInt();
        	sc.nextLine();
        	boolean notexist=true;
        	for(Resume resume:resumes) {
        		if(k == resume.getProcess()) {
        			notexist=false;
        			System.out.println(resume);
        		}
        	}
        	if(notexist)
        		System.out.println("不存在该状态的简历");
        	System.out.println("*****是否继续查询（是/否）*****");
            if(sc.nextLine().equals("是"))
            	keepon=true;
            else
            	keepon=false;
    	}while(keepon);
//    	sc.close();
    }
	
	// 添加指定简历
    public static void addResume() {
    	LinkedList<Resume> resumes = new LinkedList<>();
    	DataOperate.loadData(resumes);
        Scanner sc = new Scanner(System.in);
        boolean keepon=false;
        do {
        	System.out.println("*****请依次输入姓名、身份证号、学历、电话号、简历状态（以行隔开）*****");
            String name = sc.nextLine();
            String id = sc.nextLine();
            String education = sc.nextLine();
            String telephone = sc.nextLine();
            int process = sc.nextInt();
            sc.nextLine();
            Resume resume = new Resume(name, id, education, telephone, process);
            resumes.add(resume);
            
            System.out.println("*****是否继续添加（是/否）*****");
            if(sc.nextLine().equals("是"))
            	keepon=true;
            else
            	keepon=false;
        }while(keepon);
//        sc.close();
        DataOperate.saveData(resumes);
        System.out.println("添加成功");
    }

    //删除指定简历
    public static void deleteResume() {
    	LinkedList<Resume> resumes = new LinkedList<>();
    	DataOperate.loadData(resumes);
    	if (resumes.size() == 0) {
            System.out.println("HR系统为空");
            return;
        }
        Scanner sc = new Scanner(System.in);
        boolean keepon=false;
        do {
        	System.out.println("*****请输入要删除的简历对应的身份证号*****");
            String id = sc.nextLine();
            boolean isnotexisted=true;
            for(int i = 0; i < resumes.size(); i++) {
            	if (resumes.get(i).getId().equals(id)) {
                	isnotexisted=false;
                	resumes.remove(resumes.get(i));
                    System.out.println("删除成功");
                }
            }
            if(isnotexisted)
            	System.out.println("没有找到您想要删除的简历");
            
            System.out.println("*****是否继续删除（是/否）*****");
            if(sc.nextLine().equals("是"))
            	keepon=true;
            else
            	keepon=false;
        }while(keepon);
//        sc.close();
        DataOperate.saveData(resumes);
        System.out.println("操作完毕");
    }

    //修改指定简历
    public static void updateResume() {
    	LinkedList<Resume> resumes = new LinkedList<>();
    	DataOperate.loadData(resumes);
    	if (resumes.size() == 0) {
            System.out.println("HR系统为空");
            return;
        }
        Scanner sc = new Scanner(System.in);
        boolean keepon=false;
        do {
        	System.out.println("*****请输入要修改的简历对应的身份证号*****");
            String id = sc.nextLine();
            boolean isnotexisted=true;
            for (Resume resume : resumes) {
                if (resume.getId().equals(id)) {
                	isnotexisted=false;
                	boolean iscompleted=false;
                	do {
                		System.out.println("*****已找到要修改的简历*****");
                		System.out.println("****简历原始状态****");
                		System.out.println(resume);
                		System.out.println("*************************");
                    	System.out.println("修改姓名——1");
                    	System.out.println("修改身份证号——2");
                    	System.out.println("修改学历——3");
                    	System.out.println("修改电话号——4");
                    	System.out.println("修改简历状态——5");
                    	int choice=sc.nextInt();
                    	sc.nextLine();
                    	switch(choice) {
                    	case 1:
                    		{System.out.println("原始姓名：" + resume.getName());
                    		System.out.println("请输入新的姓名");
                    		resume.setName(sc.nextLine());}
                            break;
                        case 2:
                        	{System.out.println("原始身份证号：" + resume.getId());
                        	System.out.println("请输入新的身份证号");
                        	resume.setId(sc.nextLine());}
                            break;
                        case 3:
                        	{System.out.println("原始学历：" + resume.getEducation());
                        	System.out.println("请输入新的学历");
                        	resume.setEducation(sc.nextLine());}
                            break;
                        case 4:
                        	{System.out.println("原始电话号：" + resume.getTelephone());
                        	System.out.println("请输入新的电话号");
                        	resume.setTelephone(sc.nextLine());}
                            break;
                        case 5:
                        	{System.out.println("原始简历状态：" + resume.getProcess());
                        	System.out.println("请输入新的简历状态");
                        	resume.setProcess(sc.nextInt());
                        	sc.nextLine();}
                            break;
                        default:
                            System.out.println("输入有误，请重新输入");
                    	}
                    	
                    	System.out.println("*****是否继续修改本简历（是/否）*****");
                        if(sc.nextLine().equals("是"))
                        	iscompleted=true;
                        else
                        	iscompleted=false;
                	}while(iscompleted);
                    System.out.println("修改成功");
                }
            }
            if(isnotexisted)
            	System.out.println("没有找到您想要修改的简历");
            
            System.out.println("*****是否继续修改下一个简历（是/否）*****");
            if(sc.nextLine().equals("是"))
            	keepon=true;
            else
            	keepon=false;
        }while(keepon);
//        sc.close();
        DataOperate.saveData(resumes);
        System.out.println("操作完毕");
    }

    // 查询指定简历
    public static void searchResume() {
    	LinkedList<Resume> resumes = new LinkedList<>();
    	DataOperate.loadData(resumes);
    	if (resumes.size() == 0) {
            System.out.println("HR系统为空");
            return;
        }
        Scanner sc = new Scanner(System.in);
        boolean keepon=false;
        do {
        	System.out.println("*****请输入要查询的简历对应的身份证号*****");
            String id = sc.nextLine();
            boolean isnotexisted=true;
            for (Resume resume : resumes) {
                if (resume.getId().equals(id)) {
                	isnotexisted=false;
                    System.out.println("找到要查询的简历");
                    System.out.println(resume);
                }
            }	
            if(isnotexisted)
            	System.out.println("没有找到您想要查询的简历");
            
            System.out.println("*****是否继续查询（是/否）*****");
            if(sc.nextLine().equals("是"))
            	keepon=true;
            else
            	keepon=false;
        }while(keepon);
//        sc.close();
        System.out.println("查询完毕");
    }

}
