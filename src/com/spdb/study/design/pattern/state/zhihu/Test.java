package com.spdb.study.design.pattern.state.zhihu;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 20:18
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();

        context.favorite();

        context.comment("文章见解深刻，已友情三连");
    }
}
