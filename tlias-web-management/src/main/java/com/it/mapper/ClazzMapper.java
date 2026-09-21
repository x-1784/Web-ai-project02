package com.it.mapper;


import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 班级管理条件分页查询
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);
}
