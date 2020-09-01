package com.cuit.builder;

import com.cuit.model.BenzModel;
import com.cuit.model.CarModel;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benz = new BenzModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
