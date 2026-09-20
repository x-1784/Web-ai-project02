package com.it.service;

import com.it.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有部门数据
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
