package com.it.mapper;


import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 班级管理，根据id查询班级，即查询回显
     */
    @Select("select * from clazz where id=#{id}")
    Clazz getById(Integer id) ;


    /**
     * 班级管理条件分页查询
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 新增班级
     */
    @Insert("insert into clazz(name, room, begin_date, end_date,  master_id,subject, create_time, update_time) " +
            "VALUES(#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime}) ")
    void save(Clazz clazz);


    /**
     * 修改班级信息，班级管理
     */
    void update(Clazz clazz);


    /**
     * 根据id删除班级信息，班级管理
     */
    //查询班级里的学生数量，有学生的话不能删除
    @Select("select count(*) from student where clazz_id=#{id}")
    Integer countStudentByClazzId(Integer id);

    //删除班级根据id
    @Delete("delete from clazz where id =#{id}")
    void deleteById(Integer id);


    /**
     * 学员管理，班级管理，查询所有班级列表
     */
    @Select("select * from clazz")
    List<Clazz> clazzList();
}
