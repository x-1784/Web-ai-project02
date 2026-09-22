package com.it.mapper;

import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 学员管理，条件分页查询
     */
    List<Student> list(StudentQueryParam studentQueryParam);


    /**
     * 学员管理，添加学生
     */
    @Insert("insert into student (name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id,  create_time, update_time)" +
            "values(#{name},#{no},#{gender},#{phone},#{idCard},#{isCollege},#{address},#{degree},#{graduationDate},#{clazzId},#{createTime},#{updateTime})")
    void save(Student student);

    /**
     * 根据id查询学生，学生管理
     */
    Student getById(Integer id);

    /**
     * 修改学生信息，学生管理
     */
    void update(Student student);

    /**
     * 批量删除学生，学生管理
     */
    void deleteByIds(List<Integer> ids);
}
