package com.cuit.builder;

import com.cuit.model.CarModel;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class CarBuilder {
    /**
     * 功能描述:
     * 建造一个模型，你要给我一个顺序要求，就是组装顺序
     *
     * @param sequence 1
     * @return: void
     * @author: liwenyi
     */
    public abstract void setSequence(ArrayList<String> sequence);
    /**
     * 功能描述:
     * 设置完毕顺序后，就可以直接拿到这个车辆模型
     *
     * @return: com.cuit.model.CarModel
     * @author: liwenyi
     */
    public abstract CarModel getCarModel();
}
