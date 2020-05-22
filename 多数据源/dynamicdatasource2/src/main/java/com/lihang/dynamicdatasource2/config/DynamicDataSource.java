package com.lihang.dynamicdatasource2.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();
    public DynamicDataSource(DataSource dataSource, Map<String,DataSource> targetDataSource){
        super.setDefaultTargetDataSource(dataSource);
        super.setTargetDataSources(new HashMap<>(targetDataSource));
        super.afterPropertiesSet();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }



    /*dataSource的名称*/
    public static String getDataSource(){
        return CONTEXT_HOLDER.get();
    }

    public static void setDataSource(String dataSource){
        CONTEXT_HOLDER.set(dataSource);
    }

    public static void clearDataSource(){
            CONTEXT_HOLDER.remove();

    }
}
