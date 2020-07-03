package com.spdb.util;

import com.spdb.pojo.Resume;


/**
 * @Author: A wei
 * @Date: 2020/7/1 12:47
 * @Last Modified by:
 * @last Modified date:
 * @Description: 函数式接口用来check简历信息
 */
public interface IResumeCheck {

    boolean checked(Resume resume1, Resume resume2);

}
