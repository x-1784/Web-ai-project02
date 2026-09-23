package com.it.mapper;

import com.it.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept order by update_time desc ;")
    List<Dept> findAll();

    /**
     * 部门管理，根据id删除部门
     */
    //查询该部门下面是否有员工，有员工不能删除
    @Select("select count(*) from emp where id =#{id}")
    Integer countemp(Integer id);
    //根据id删除部门
    @Delete("delete from dept where id =#{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept getById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}




























