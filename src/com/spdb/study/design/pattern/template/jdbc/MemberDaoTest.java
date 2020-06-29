package com.spdb.study.design.pattern.template.jdbc;
import	java.util.List;

import com.spdb.study.design.pattern.template.jdbc.dao.MemberDao;

/**
 * @author Mr.Longyx
 * @date 2020年06月29日 21:37
 */
public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
