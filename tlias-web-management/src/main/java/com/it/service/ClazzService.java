package com.it.service;

import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import com.it.pojo.PageResult;

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
}
