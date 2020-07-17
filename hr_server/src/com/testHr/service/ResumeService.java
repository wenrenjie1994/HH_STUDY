package com.testHr.service;

import com.testHr.dto.ResumeDTO;

import java.io.PrintWriter;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public interface ResumeService {
    ResumeDTO dealWith(String message, PrintWriter out);
}
