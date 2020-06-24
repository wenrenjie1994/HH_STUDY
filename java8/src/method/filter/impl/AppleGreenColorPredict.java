package method.filter.impl;

import method.Apple;
import method.filter.ApplePredict;

/**
 * @Author: A wei
 * @Date: 2020/6/24 16:37
 * @Last Modified by: {@link ApplePredict}
 * @last Modified date:
 * @Description: predict green color of Apple
 */
public class AppleGreenColorPredict implements ApplePredict {
    @Override
    public boolean predict(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
