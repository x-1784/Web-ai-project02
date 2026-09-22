package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private Integer page=1;  //分页查询的页码
    private Integer pageSize=10;  //分页查询的每页记录数
    private String name;    //学生姓名
    private String degree;  //学历
    private Integer clazzId;  //班级ID
}
