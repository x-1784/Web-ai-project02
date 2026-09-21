package com.it.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.mapper.ClazzMapper;
import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import com.it.pojo.PageResult;
import com.it.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        LocalDate now = LocalDate.now();
        clazzList.forEach(c -> {
            if (now.isAfter(c.getEndDate())) {          // 当前时间 > 结课时间
                c.setStatus("已结课");
            } else if (now.isBefore(c.getBeginDate())) { // 当前时间 < 开课时间
                c.setStatus("未开班");
            } else {
                c.setStatus("在读中");
            }
        });



        Page<Clazz> p =(Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }
}
