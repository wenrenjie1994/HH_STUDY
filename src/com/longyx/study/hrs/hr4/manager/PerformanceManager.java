package com.spdb.study.hrs.hr4.manager;

import com.spdb.study.hrs.hr4.dataobject.Performance;

import java.util.List;

/**
 * 绩效接口
 * @author Mr.Longyx
 * @date 2020年07月25日 13:16
 */
public interface PerformanceManager {
    /**
     * 添加绩效
     * @author Mr.Longyx
     * @date 2020/7/25 13:18
     * @param performance
     */
    void addPerformance(Performance performance);
    /**
     * 修改绩效
     * @author Mr.Longyx
     * @date 2020/7/25 13:19
     * @param performance
     */
    void updatePerformance(Performance performance);

    /**
     * 删除绩效
     * @author Mr.Longyx
     * @date 2020/7/25 13:20
     * @param employeeId
     * @param examineTypeId
     */
    void deletePerformance(int employeeId, int examineTypeId);

    /**
     * 根据员工Id查询绩效列表
     * @author Mr.Longyx
     * @date 2020/7/25 13:23
     * @param employeeId 
     * @return java.util.List<com.spdb.study.hrs.hr4.dataobject.Performance>
     */
    List<Performance> findPerformanceListByEmployeeId(int employeeId);
    
    /**
     * 查询每个考核类别下的最高绩效
     * @author Mr.Longyx
     * @date 2020/7/25 13:24 
     * @return java.util.List<com.spdb.study.hrs.hr4.dataobject.Performance>
     */
    List<Performance> findHigherPerformanceList();
    /**
     * 查询前三名
     * @author Mr.Longyx
     * @date 2020/7/25 13:25 
     * @return java.util.List<com.spdb.study.hrs.hr4.dataobject.Performance>
     */
    List<Performance> findPerformanceListTop3();
    /**
     * 分页查询员工绩效信息
     * @author Mr.Longyx
     * @date 2020/7/25 13:27
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.spdb.study.hrs.hr4.dataobject.Performance>
     */
    List<Performance> findPerformanceList(int pageNum, int pageSize);
}
