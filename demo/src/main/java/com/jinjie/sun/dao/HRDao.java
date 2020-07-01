package com.jinjie.sun.dao;

import com.jinjie.sun.pojo.HR;

import java.util.List;

public interface HRDao {
    int add(HR hr);

    int update(HR hr);

    int delete(Long id);

    HR findHR(Long id);

    List<HR> findHRList();
}
