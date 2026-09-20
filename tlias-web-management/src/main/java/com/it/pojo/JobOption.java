package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 用于员工信息统计图表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {

    private List jobList;  //职位列表
    private List dataList; //数据列表
}
