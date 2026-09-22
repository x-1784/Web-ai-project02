package com.it.service;

import com.it.pojo.PageResult;
import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    /**
     * 学员管理，条件分页查询
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);


    /**
     * 学员管理，添加学生
     */
    void save(Student student);


    /**
     * 根据id查询学生，学生管理
     */
    Student getinfo(Integer id);

    /**
     * 修改学生信息，学生管理
     */
    void update(Student student);

    /**
     * 批量删除学生，学生管理
     */
    void delete(List<Integer> ids);

    /**
     * 学生违纪处理
     */
    void updateViolation(Integer id,Integer score);
}
