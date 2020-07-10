# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:23
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : student.py
# @Software: PyCharm

class student():
    def __init__(self, name, IDcard, phoneNumber, gender, birthday, age,
                 degree, school, job, salary, isDelete=False):
        '''
        传入姓名、身份证号、手机号，性别、出生日期、年龄、
        学历、学校、应聘岗位、期望薪资,是否删除默认为False。
        :param name: 姓名
        :param IDcard: 身份证号
        :param phoneNumber: 姓名
        :param gender: 性别
        :param birthday: 出生日期
        :param age: 年龄
        :param degree: 学历
        :param school: 学校
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
        self.degree = degree
        self.school = school
        self.job = job
        self.salary = salary
        self.isDelete = isDelete

    def select(self):
        print(self.name, self.IDcard, self.phoneNumber, self.gender,
              self.birthday, self.age, self.degree, self.school)
        print("应聘工作", self.job, "期望薪资", self.salary)

    def writeInfo(self):
        strStudent=\
            self.name+"\t"+self.IDcard+"\t"+self.phoneNumber+"\t"+self.gender+"\t"+self.birthday+"\t"+self.age+"\t"+self.degree+"\t"+self.school+ "\t"+self.job+"\t"+self.salary+"\t"+str(self.isDelete)+"\n"
        return strStudent