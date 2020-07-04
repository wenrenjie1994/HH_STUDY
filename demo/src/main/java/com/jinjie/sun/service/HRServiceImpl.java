package com.jinjie.sun.service;

import com.jinjie.sun.dao.HRDao;
import com.jinjie.sun.pojo.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRServiceImpl implements HRService {
    @Autowired
    private HRDao hrDao;

    @Override
    public int add(HR hr) {
        return this.hrDao.add(hr);
    }

    @Override
    public int update(HR hr) {
        return this.hrDao.update(hr);
    }

    @Override
    public int delete(Long id) {
        return this.hrDao.delete(id);
    }

    @Override
    public HR findHR(Long id) {
        return this.hrDao.findHR(id);
    }

    @Override
    public List<HR> findHRList() {
        return this.hrDao.findHRList();
    }
}
