package com.spdb.lowbhrsys.service.impl;

import com.spdb.lowbhrsys.bean.ResumeBean;
import com.spdb.lowbhrsys.service.IResumeService;
import com.spdb.lowbhrsys.utils.ResponseData;

import java.io.*;
import java.util.List;

/**
 * @author: libobo
 * @create: 2020-07-04 13:41
 * @description:
 **/
public class ResumeFileServiceImpl implements IResumeService {
    @Override
    public ResponseData addResume(ResumeBean resume) {
        return null;
    }

    @Override
    public ResponseData deleteResume(int resumeId) {
        return null;
    }

    @Override
    public ResponseData updateResume(int resumeId, String name, String email, String phone) {
        return null;
    }

    @Override
    public ResponseData<ResumeBean> findResumeByResumeId(int resumeId) {
        return null;
    }

    @Override
    public ResponseData<List<ResumeBean>> findAllResume() {
        return null;
    }

}
