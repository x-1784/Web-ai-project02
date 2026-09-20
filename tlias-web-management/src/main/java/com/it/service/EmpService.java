package com.it.service;

import com.it.pojo.Emp;
import com.it.pojo.EmpQueryParam;
import com.it.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     */
    void save(Emp emp) ;

    void delete(List<Integer> ids);


    //根据id查询员工信息
    Emp getInfo(Integer id);

    /**
     * 修改员工
     */
    void update(Emp emp);
}
