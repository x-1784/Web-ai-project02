package com.it.service.impl;

import com.it.mapper.ClazzMapper;
import com.it.mapper.EmpMapper;
import com.it.mapper.StudentMapper;
import com.it.pojo.ClazzOption;
import com.it.pojo.JobOption;
import com.it.pojo.Student;
import com.it.service.ReportService;
import com.it.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {

        //1.调用mapper接口，获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpjobData(); // map:  pos=教研主管，num=1  这是一行

        //2.组装结果，并返回
        List<Object> joblist = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> datalist = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(joblist,datalist);
    }


    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public ClazzOption getClazzCount() {
        //1.调用mapper接口，获取统计数据
        List<Map<String, Object>> list =clazzMapper.countClazzData();

        //2.组装结果，并返回
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazzName")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new ClazzOption(clazzList,dataList);
    }

    @Override
    public List<Map<String, Object>> countStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }
}



































