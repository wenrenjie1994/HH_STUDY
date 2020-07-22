package com.spdb;

import com.spdb.builder.BenzBuilder;
import com.spdb.builder.BmwBuilder;
import com.spdb.model.BenzModel;
import com.spdb.model.BmwModel;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Director {
    private ArrayList<String> sequence = new ArrayList();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BmwBuilder bmwBuilder = new BmwBuilder();

    /**
     * 功能描述:
     * A类型的奔驰车模型，先start，然后stop，其他什么引擎、喇叭一概没有
     *
     * @return: com.spdb.model.BenzModel
     * @author: liwenyi
     */
    public BenzModel getABenzModel() {
        //清理场景，这里是一些初级程序员不注意的地方
        this.sequence.clear();
        //ABenzModel的执行顺序
        this.sequence.add("start");
        this.sequence.add("stop");
        //按照顺序返回一个奔驰车
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    /**
     * 功能描述:
     * B型号的奔驰车模型，是先发动引擎，然后启动，然后停止，没有喇叭
     *
     * @return: com.spdb.model.BenzModel
     * @author: liwenyi
     */
    public BenzModel getBBenzModel() {
        this.sequence.clear();
        this.sequence.add("engine boom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    /**
     * 功能描述:
     * C型号的宝马车是先按下喇叭（炫耀嘛），然后启动，然后停止
     *
     * @return: com.spdb.model.BmwModel
     * @author: liwenyi
     */
    public BmwModel getCBMWModel() {
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BmwModel) this.bmwBuilder.getCarModel();
    }

    /**
     * 功能描述:
     * D类型的宝马车只有一个功能，就是跑，启动起来就跑，永远不停止
     *
     * @return: com.spdb.model.BmwModel
     * @author: liwenyi
     */
    public BmwModel getDBMWModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.bmwBuilder.setSequence(this.sequence);
        return (BmwModel) this.benzBuilder.getCarModel();
    }
}
