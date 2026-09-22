package com.it.service;

import com.it.pojo.PageResult;
import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;

public interface StudentService {

    /**
     * 学员管理，条件分页查询
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);


    /**
     * 学员管理，添加学生
     */
    void save(Student student);
}
