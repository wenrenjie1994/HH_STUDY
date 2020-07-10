package com.pan.team.service;

import com.pan.team.domain.Employee;
import com.pan.team.domain.Programmer;

public class TeamService {

	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;

	/**
	 * 
	 * Description 返回当前团队的所有对象 
	 * @author Pan  Email:zhaopan1848@163.com
	 * @date 2020年4月10日下午4:39:13
	 * @return 包含所有成员对象的数组，数组大小与成员人数一
	 */
	public Programmer[] getTeam() {
		Programmer[] allTeam = new Programmer[total];
		for (int i = 0; i < total; i++) {
			allTeam[i] = team[i];
		}

		return allTeam;
	}

	public void addMember(Employee e) throws TeamException {
		//开发团队人员组成要求： – 最多一名架构师 – 最多两名设计师 – 最多三名程序员
		
		//成员已满，无法添加 
		if(total>=3) {
			throw new TeamException("成员已满，无法添加");
		}
		
		//该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		
		//该员工已在本开发团队中
		for(int i=0; i<total;i++) {
			if(e.getId() == team[i].getId()) {
				throw new TeamException("该员工已在本开发团队中");
			}
		}
		
		//该员工已是某团队成员
		//该员正在休假，无法添加
		if(e instanceof Programmer) {
			Programmer e1 = (Programmer) e;
			 if(e1.getStatus() == Status.BUSY) {
				 throw new TeamException("该员工已是某团队成员");
			 }else if(e1.getStatus() == Status.VACATION) {
				 throw new TeamException("该员正在休假，无法添加");
			 }
			
		}
		
		

//团队中至多只能有一名架构师 
//团队中至多只能有两名设计师 
//团队中至多只能有三名程序员

	}

	public void removeMember(int memberId) {

	}

}
