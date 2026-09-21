package com.it.service;

import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import com.it.pojo.PageResult;

public interface ClazzService {

    //班级管理条件分页查询
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);
}
