package com.it.controller;

import com.it.pojo.PageResult;
import com.it.pojo.Result;
import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;
import com.it.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 根据id查询学生，学生管理
     */
    @GetMapping("/{id}")
    public Result getinfo(@PathVariable Integer id){
        log.info("根据id查询学生：{}",id);
        Student student= studentService.getinfo(id);
        return Result.success(student);
    }

    /**
     * 修改学生信息，学生管理
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生信息：{}",student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 批量删除学生，学生管理
     */
    @DeleteMapping("/{ids}")  //接口文档说前端是路径参数，所以用注解@PathVariable,查询参数才用@requestparam
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学生的id：{}",ids);
        studentService.delete(ids);
        return Result.success();
    }

}




















