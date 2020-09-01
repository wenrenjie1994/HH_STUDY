package com.cuit.builder;

import com.cuit.model.BmwModel;
import com.cuit.model.CarModel;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class BmwBuilder extends CarBuilder {

    private BmwModel bmw = new BmwModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
}
