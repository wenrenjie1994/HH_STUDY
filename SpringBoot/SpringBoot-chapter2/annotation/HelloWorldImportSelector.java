package com.example.demo.annotation;

import com.example.demo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: A wei
 * @Date: 2020/6/7 11:37
 * @Last Modified by:
 * @last Modified date:
 * @Description: 接口编程方式
 */
public class HelloWorldImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
