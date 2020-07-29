# -*- coding: utf-8 -*-
# @Time    : 2019/5/25 22:43
# @Author  : 唐家鑫
# @Email   : 1280445703@qq.com
# @File    : conDatabase.py
# @Software: PyCharm


import pymysql


class tomSql():
    def __init__(self, host, port, user, passwd, dbName):
        self.host = host
        self.port = port
        self.user = user
        self.passwd = passwd
        self.dbName = dbName

    def connect(self):
        self.db = pymysql.connect(host=self.host, port=self.port,
                                  user=self.user, passwd=self.passwd,
                                  db=self.dbName, charset='utf8')

        self.cursor = self.db.cursor()

    def close(self):
        self.cursor.close()
        self.db.close()

    def get_one(self, sql):
        result = None
        try:
            self.connect()
            self.cursor.execute(sql)
            result = self.cursor.fetchone()
            self.close()
        except:
            print('查询失败')

        return result

    def get_all(self, tbName, content="*", factor="null", tbName2="null", joinFactor="null"):
        '''
        查询数据库多条内容
        :param tbName: 表名
        :param content: 需要查询的内容，默认"*"
        :param factor: 查询结果所需要满足的条件
        :param tbName2: 需要连接的另一个表
        :param joinFactor: 连接两个表的条件
        :return: 返回数据库中查询结果
        '''

        if factor == "null" and joinFactor == "null":
            sql = "SELECT DISTINCT " + content + " FROM " + tbName + ";"
        elif factor == "null" and joinFactor != "null":
            sql = "SELECT DISTINCT " + content + " FROM " + tbName + " JOIN " + tbName2 + " on " + joinFactor + ";"
        elif factor != "null" and joinFactor == "null":
            sql = "SELECT DISTINCT " + content + " FROM " + tbName + " WHERE " + factor + ";"
        else:
            sql = "SELECT DISTINCT " + content + " FROM " + tbName + " JOIN " + tbName2 + " on " + \
                  joinFactor + " WHERE " + factor + ";"
        # print(sql)
        result = None
        try:
            self.connect()
            self.cursor.execute(sql)
            result = self.cursor.fetchall()
            self.close()
        except Exception as e:
            print(e)
            print('查询失败')

        return result

    def update(self, tbName, content, factor="null"):
        '''
        更新数据库中表的内容
        :param tbName: 表名
        :param content: 要更新的内容
        :return: 数据库更新操作是否成功
        '''
        if factor == "null":
            sql = "update " + tbName + " set " + content + ";"
        else:
            sql = "update " + tbName + " set " + content + " WHERE " + factor + ";"
        return self.__edit(sql)

    def delete(self, tbName, factor="null"):
        '''
        删除数据库表中的内容
        :param tbName: 数据表名
        :param factor: 删除数据项所满足的条件
        :return: 数据库删除操作是否成功
        '''
        if factor == "null":
            sql = "delete from " + tbName
        else:
            sql = "delete from " + tbName + " where " + factor + ";"
        return self.__edit(sql)

    def insert(self, tbname, content, tbFactor="null"):
        '''
        向数据库中添加数据
        :param tbname: 数据表名
        :param content: 需要插入的内容
        :param tbFactor: 在表的某些列操作
        :return: 数据库插入操作是否成功
        '''
        if tbFactor == "null":
            sql = "insert into " + tbname + " values " + content + ";"
        else:
            sql = "insert into " + tbname + " " + tbFactor + " values " + content + ";"
        # print(sql)
        return self.__edit(sql)

    def __edit(self, sql):

        try:
            self.connect()
            result = self.cursor.execute(sql)
            self.db.commit()
            self.close()
        except Exception as e:
            print(e)
            print("事物提交失败")
            self.db.rollback()
            result = False
            return result

        return result


if __name__ == '__main__':
    db = tomSql('cdb-5buhylba.cd.tencentcdb.com', 10056, 'root', 'tangjiaxin19971218', 'hrSystem')
    # 查询列名
    # result = db.get_all("SELECT column_name FROM information_schema.columns WHERE  table_name='student';")
    result = db.get_all(content="column_name", tbName="information_schema.columns", factor="table_name='student'")
    print(result)
    print(db.get_all("student"))
    print(db.get_all("stuEducation"))
    print(db.insert("student", "('11', 11, 151, '男', '11', 11, '11', 11, 0),"))
