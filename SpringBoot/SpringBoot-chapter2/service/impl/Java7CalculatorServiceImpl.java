package com.example.demo.service.impl;


import com.example.demo.service.CalculatorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Author: A wei
 * @Date: 2020/6/7 15:17
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
@Profile("java7")
@Service
public class Java7CalculatorServiceImpl implements CalculatorService {

    @Override
    public Integer sum(Integer... values) {
        System.out.println("java7 for循环实现");

        int sum = 0;

        for (int i = 0 ; i < values.length; i++){
            sum+= values[i];
        }
        return sum;
    }
}
