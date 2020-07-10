# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:34
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : hr.py
# @Software: PyCharm
from HRsystem.student.student import student


class hr():
    def __init__(self,url):
        self.url=url
        self.student = {}
        self.info = {"姓名": "name", "身份证号": "IDcard", "手机号": "phoneNumber", "性别": "gender",
                     "出生日期": "birthday", "年龄": "age", "学历": "degree",
                     "学校": "school", "应聘岗位": "job", "期望薪资": "salary"}
        self.readTxt()

    def add(self):
        try:
            name, IDcard, phoneNumber, gender, birthday, age, degree, school, job, salary \
                = input("请按照姓名、身份证号、手机号，性别、出生日期、年龄、学历、学校、应聘岗位、期望薪资顺序输入").split()
            if IDcard in self.student:
                print("此身份证号已经存在，请添加不同身份证号同学")
                self.add()
            else:
                self.student[IDcard] = \
                    student(name, IDcard, phoneNumber, gender, birthday, age, degree, school, job, salary)
                print("添加成功!!!")
        except Exception as e:
            print("输入结构出错，请重新输入")
            self.add()

    def delete(self):
        try:
            IDcard = input("请输入要删除学生的身份证号")
            if self.student[IDcard].isDelete == True:
                print("输入结构或信息出错，请重新输入")
                self.delete()
            else:
                self.student[IDcard].isDelete = True
                print("删除成功")
        except Exception as e:
            print("输入结构或信息出错，请重新输入")
            self.delete()

    def alter(self):
        '''
        利用Python的反射方法更改类中的信息
        :return:
        '''
        try:
            string = input("请输入要更正的信息类别")
            if string == "身份证号":
                print("身份证为不可修改信息！请重新输入")
                self.alter()
            else:
                IDcard, info = input("请按身份证号、更正信息输入要更正的信息").split()
                # setattr(obj, attr, val):
                # 调用这个方法将给obj的名为attr的值的属性赋值为val。例如如果attr为’bar’，则相当于obj.bar = val。
                # print(self.info[string])
                setattr(self.student[IDcard], self.info[string], info)
                print("更改成功")
        except Exception as e:
            print(e)
            print("输入结构出错，请重新输入")
            self.alter()

    def select(self):
        for k, v in self.student.items():
            if v.isDelete == False:
                v.select()
        print("查询完毕！！！")

    def printWelcome(self):
        print("====欢迎进入Hr系统！！！===")
        print("请输入对应的数字表示进行操作！")
        print("请按1进行增加学生信息操作")
        print("请按2进行删除学生信息操作")
        print("请按3进行更改学生信息操作")
        print("请按4进行查询学生信息操作")
        print("请按5退出程序")
        return 5

    def choose(self, num):
        if num == 1:
            self.add()
        elif num == 2:
            self.delete()
        elif num == 3:
            self.alter()
        elif num == 4:
            self.select()
        elif num ==5:
            self.writeTxt()
            print("程序结束！！！感谢使用。")
            return True
        return False

    def inputNum(self, max):
        try:
            num = int(input())
        except Exception as e:
            print("输入非数字，请重新输入")
            num = self.inputNum(max)
        if num > max or num < 1:
            num = self.inputNum(max)

        return num

    def writeTxt(self):
        with open(self.url, "wb") as f1:
            for k,v in self.student.items():
                # print(v)
                f1.write(v.writeInfo().encode("utf-8"))

    def readTxt(self):
        try:
            with open(self.url, "rb") as f2:
                for i in f2.readlines():
                    # print(i.decode("utf-8"))
                    name, IDcard, phoneNumber, gender, birthday, age, degree, school, job, salary,isDelete \
                        = i.decode("utf-8").split("\t")
                    # print(bool(isDelete))
                    # print(isDelete)
                    self.student[IDcard] = \
                        student(name, IDcard, phoneNumber, gender, birthday, age,
                                degree, school, job, salary,"True"==isDelete)
                    # print(self.student)
        except Exception as e:
            print(e)


    def saveToDatabase(self):
        pass


if __name__ == '__main__':
    hr1 = hr('studentInfo.txt')
    while True:
        max = hr1.printWelcome()
        num = hr1.inputNum(max)
        if hr1.choose(num):
            break
