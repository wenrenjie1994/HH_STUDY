package com.cuit;

import com.cuit.model.SchoolReport;
import com.cuit.model.SugarFouthGradeSchoolReport;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Father {
    public static void main(String[] args) {
        //把美化过的成绩单拿过来
        SchoolReport sr= new SugarFouthGradeSchoolReport();
        //看成绩单
        sr.report();
        //然后老爸，一看，很开心，就签名了
        //我叫小三，老爸当然叫老三
        sr.sign("老三");
    }
}
