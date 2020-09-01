package com.cuit.command;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class DeletePageCommand extends Command {
    @Override
    /**
     * 功能描述:
     * 执行删除一个页面的命令
     *
     * @return: void
     * @author: liwenyi
     */
    public void execute() {
        //找到页面组
        super.pg.find();
        //删除一个页面
        super.rg.delete();
        //给出计划
        super.rg.plan();
    }
}
