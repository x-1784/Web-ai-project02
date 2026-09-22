package com.it.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.mapper.StudentMapper;
import com.it.pojo.PageResult;
import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;
import com.it.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentMapper studentMapper;


    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> list = studentMapper.list(studentQueryParam);
        Page<Student> p = (Page<Student>) list;
        return new  PageResult<Student>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.save(student);
    }
}
