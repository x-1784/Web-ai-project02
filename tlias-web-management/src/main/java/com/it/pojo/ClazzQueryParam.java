package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzQueryParam {
    private Integer page=1;//页码
    private Integer pageSize=10;//每页展示记录数
    private String name;//班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//入职时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//离职时间
}
