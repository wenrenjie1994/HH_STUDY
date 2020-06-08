package com.example.demo.service.impl;

import com.example.demo.service.CalculatorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @Author: A wei
 * @Date: 2020/6/7 15:18
 * @Last Modified by:
 * @last Modified date:
 * @Description: {@link CalculatorService}
 */
@Profile("java8")
@Service
public class Java8CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("java8 Lambda实现");
        Integer sum = Stream.of(values).reduce(0,Integer::sum);
        return sum;
    }
}
