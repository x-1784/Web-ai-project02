package com.it.mapper;

import com.it.pojo.Emp;
import com.it.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface EmpMapper {
    //-------------------------------------------原始分页查询操作
//    //查询总记录数
//    @Select("select count(*) from emp e left join dept d on e.dept_id=d.id")
//    public long count();
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc" +
//            " limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start,Integer pageSize);

    //--------------------------------------------PageHelper插件分页查询操作
    /*@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc" )*/
    //条件查询员工信息的方法
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "VALUES(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);


    /**
     *根据id批量删除员工信息
     */
    void deleteByIds(List<Integer> ids);


    /**
     * 根据id查询员工信息以及员工工作经历信息
     */
    Emp getById(Integer id);

    void updateById(Emp emp);


    //员工信息统计图表
    //  形式： pos=教研主管，num=1  这是一行
    List<Map<String, Object>> countEmpjobData();


    /**
     * 统计员工性别人数
     */
    List<Map<String, Object>> countEmpGenderData();

    /**
     * 询全部员工，班级管理查询所有班主任
     */
    @Select("select * from emp")
    List<Emp> AllList();
}















































