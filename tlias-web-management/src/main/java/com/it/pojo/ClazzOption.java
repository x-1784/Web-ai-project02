package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
  用于班级人数统计图表
 */
public class ClazzOption {
    private List clazzList;//班级列表
    private List dataList;//数据列表
}
