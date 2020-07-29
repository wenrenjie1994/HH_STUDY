# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:23
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : student.py
# @Software: PyCharm

class student():
    def __init__(self, name, IDcard, phoneNumber, gender, birthday, age,
                 job, salary, isDelete=False):
        '''
        传入姓名、身份证号、手机号，性别、出生日期、年龄、
        学历、学校、应聘岗位、期望薪资,是否删除默认为False。
        :param name: 姓名
        :param IDcard: 身份证号
        :param phoneNumber: 姓名
        :param gender: 性别
        :param birthday: 出生日期
        :param age: 年龄

        :param job: 应聘岗位
        :param salary: 期望薪资
        :param isDelete: 是否删除默认为False
        '''
        self.name = name
        self.IDcard = IDcard
        self.phoneNumber = phoneNumber
        self.gender = gender
        self.birthday = birthday
        self.age = age
        self.job = job
        self.salary = salary
        self.isDelete = isDelete
        self.degree = {}
        self.dict = {True: 1, False: 0}
        self.setEvent()
        self.situation = {"0": "未通过", "1": "通过", "2": "进程中"}

    def select(self):
        str1 = \
            self.name + " " + str(self.IDcard) + " " + str(self.phoneNumber) + " " + self.gender + " " \
            + self.birthday + " " + str(self.age) + " " + str(self.job) + " " + str(self.salary)+"\n"
        # print(111)
        if self.getEducation():
            str1=str1+self.getEducation()
        # print(222)
        str1=str1+"应聘工作 "+ self.job+" 期望薪资 "+self.salary+"\n"
        if self.getEvent():
            str1=str1+self.getEvent()
        # print(333)
        return str1

    def setEducation(self, degree, school, startTime, endTime):
        '''
        设置教育经历
        :param degree:学历如“本科”
        :param school: 毕业学校
        :param startTime: 开始时间
        :param endTime: 结束时间
        :return:
        '''
        self.degree[degree] = [degree, school, startTime, endTime]

    def getEducation(self):
        strEducation = ""
        for k, v in self.degree.items():
            # print(1)
            strEducation = strEducation + str(self.name) + ": " + str(v[0]) + " " + str(v[1]) + " " \
                           + str(v[2]) + " " + str(v[3]) + " "
            strEducation = strEducation + "\n"

        return strEducation

    def setEvent(self, isCVPass="2", isWriExamination="2", isInterview="2", isPhyExamination="2", isSign="2"):
        '''
        设置学生应聘某一流程情况
        数字2表示进程中，1表示通过。0表示未通过
        :return:
        '''
        self.event = {"isCVPass": isCVPass, "isWriExamination": isWriExamination,
                      "isInterview": isInterview, "isPhyExamination": isPhyExamination,
                      "isSign": isSign}

    def getEvent(self):
        strEvent=self.name
        for k, v in self.event.items():
            strEvent=strEvent+k + ": " + self.situation[v]+" "
        else:
            strEvent=strEvent+"\n"

        return strEvent
    def writeInfo(self):
        '''
        设置写入数据库的数据项格式
        :param : stuEducation表的id号
        :return:返回id号，strStudent,strEducation,strEvent数据项
        '''
        # (0, '沈晓东', 21, 1, '合肥', 0),
        # (0, '唐家鑫', 23, 1, '巴中', 0);
        # strStudent = \
        #     self.name + "\t" + self.IDcard + "\t" + self.phoneNumber + "\t" + self.gender + "\t" + self.birthday + "\t" + self.age + "\t"   + self.job + "\t" + self.salary + "\t" + str(
        #         self.isDelete) + "\n"

        strStudent = \
            "('" + self.name + "','" + str(self.IDcard) + "','" + str(self.phoneNumber) + "','" + self.gender + "','" \
            + self.birthday + "','" + str(self.age) + "','" + str(self.job) + "','" + str(self.salary) + "'," + str(
                self.dict[self.isDelete]) + ")"
        # print(strStudent)
        strEducation = ""
        j = 0
        for k, v in self.degree.items():
            # print(1)
            strEducation = strEducation + "('" + str(self.phoneNumber) + "','" + str(v[0]) + "','" + str(v[1]) + "','" \
                           + str(v[2]) + "','" + str(v[3]) + "')"
            j = j + 1
            if len(self.degree) > j:
                strEducation = strEducation + ","

        # print(strEducation)
        strEvent = "(" + str(self.phoneNumber) + ",'" + self.event["isCVPass"] + "','" + self.event[
            "isWriExamination"] + "','" \
                   + self.event["isInterview"] + "','" + self.event["isPhyExamination"] + "','" + self.event[
                       "isSign"] + "')"
        # for k, v in self.event.items():
        #     strEvent = strEvent + str(v) + ","
        # strEvent = strEvent + ")"

        # print(strStudent)
        # print(strEducation)
        # print(strEvent)
        return strStudent, strEducation, strEvent
