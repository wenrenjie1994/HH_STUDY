package com.spdb.study.design.pattern.builder.sql;

import java.util.Arrays;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 16:13
 */
public class SqlBuilderTest {
    public static void main(String[] args) {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addAscOrder("age")
            .andEqual("addr","Chengdu")
            .andLike("name","Komi");

        SqlBuilder builder = new SqlBuilder(queryRule);
        System.out.println(builder.builder("user"));
        System.out.println("Params: "+ Arrays.toString(builder.getValues()));
    }
}
