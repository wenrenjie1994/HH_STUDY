package com.jinjie.sun.service;

import com.jinjie.sun.pojo.HR;

import java.util.List;

public interface HRService {
    int add(HR hr);

    int update(HR hr);

    int delete(Long id);

    HR findHR(Long id);

    List<HR> findHRList();
}
