package com.it.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.exception.ClazzHasStudentException;
import com.it.mapper.ClazzMapper;
import com.it.pojo.Clazz;
import com.it.pojo.ClazzQueryParam;
import com.it.pojo.PageResult;
import com.it.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id) {
        Integer count=clazzMapper.countStudentByClazzId(id);
        if(count>0){
            throw new ClazzHasStudentException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.deleteById(id);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.clazzList();
    }
}


















