package com.it.controller;

import com.it.pojo.PageResult;
import com.it.pojo.Result;
import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;
import com.it.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentService studentService;

    /**
     * 学员管理，条件分页查询
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询：{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 学员管理，添加学生
     */
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("添加学生：{}",student);
        studentService.save(student);
        return Result.success();
    }

}
