package method.filter.impl;

import method.Apple;
import method.filter.ApplePredict;

/**
 * @Author: A wei
 * @Date: 2020/6/24 16:35
 * @Last Modified by:
 * @last Modified date:
 * @Description: Apple Heavy weight >130 return true
 */
public class AppleHeavyWeightPredict implements ApplePredict {
    @Override
    public boolean predict(Apple apple) {
        return apple.getWeight() > 130;
    }
}
