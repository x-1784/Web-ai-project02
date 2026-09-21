package com.it.service;

import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import com.it.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    //班级管理条件分页查询
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);


    /**
     * 新增班级
     */
    void save(Clazz clazz);


    /**
     * 班级管理，根据id查询班级，即查询回显
     */
    Clazz getById(Integer id);


    /**
     * 修改班级信息，班级管理
     */
    void update(Clazz clazz);


    /**
     * 根据id删除班级信息，班级管理
     */
    void delete(Integer id);

    /**
     * 学员管理，班级管理，查询所有班级列表
     */
    List<Clazz> list();
}
