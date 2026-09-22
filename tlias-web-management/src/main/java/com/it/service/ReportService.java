package com.it.service;

import com.it.pojo.ClazzOption;
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

    /**
     * 统计班级人数，柱状图
     */
    ClazzOption getClazzCount();

    /**
     * 统计学生学历人数，饼状图
     */
    List<Map<String, Object>> countStudentDegreeData();
}
