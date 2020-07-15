package com.spdb.study.design.pattern.adapter.loginadapter.v2.adapters;

import com.spdb.study.design.pattern.adapter.loginadapter.v2.PassportForThird;
import com.spdb.study.design.pattern.adapter.loginadapter.v2.PassportForThirdAdapter;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 17:26
 */
public class PassportTest {
    public static void main(String[] args) {
        PassportForThird adapter =  new PassportForThirdAdapter();
        adapter.loginForQQ("2102584776");
    }
}
