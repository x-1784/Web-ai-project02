package com.it.mapper;

import com.it.pojo.Student;
import com.it.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

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

    /**
     * 学生违纪处理
     */
    @Update("update student set violation_count =violation_count+1," +
            "violation_score=violation_score+#{score} " +
            "where id =#{id}")
    void updateViolation(Integer id, Integer score);


    /**
     * 统计学生学历人数，饼状图
     */
    List<Map<String,Object>> countStudentDegreeData();

}
