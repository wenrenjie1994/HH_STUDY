# -*- coding: utf-8 -*-
# @Time    : 2020/7/5 11:22
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : main.py
# @Software: PyCharm
from student.student import student
from hr.hr import hr

if __name__ == '__main__':
    hr1 = hr()
    while True:
        max = hr1.printWelcome()
        num = hr1.inputNum(max)
        hr1.choose(num)
