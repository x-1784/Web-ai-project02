package com.it.service;

import com.it.pojo.JobOption;

import java.util.List;
import java.util.Map;

/**
 * 统计员工职位信息，图表
 */
public interface ReportService {
    JobOption getEmpJobData();


    /**
     * 统计员工性别人数
     */
    List<Map<String, Object>> getEmpGenderData();
}
