package com.testHr.service;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public interface ResumeService {
    void addResume(BufferedReader in,PrintWriter out);
    void deleteResume(BufferedReader in,PrintWriter out);
    void updateResume(BufferedReader in,PrintWriter out);
    void queryResume(BufferedReader in,PrintWriter out);
    void over(BufferedReader in,PrintWriter out);
}
