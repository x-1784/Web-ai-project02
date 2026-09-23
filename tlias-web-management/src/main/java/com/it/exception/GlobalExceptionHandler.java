package com.it.exception;


import com.it.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错了~",e);
        return  Result.error("出错了，请联系管理员~");
    }


    /**
     *下面这个方法是处理唯一性的异常，例如手机号已存在，或者其他唯一的字段重复
     */
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程序出错了~",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMSG = message.substring(i);
        String[] arr = errMSG.split(" ");
        return Result.error(arr[2]+"已存在");
    }

    /**
     * 处理：班级下有学生，不能删除
     */
    @ExceptionHandler
    public Result handleClazzHasStudentException(ClazzHasStudentException e){
        log.error("业务异常：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理：部门下有员工，不能删除
     */
    @ExceptionHandler
    public Result handleDeptHasEmpException (DeptHasEmpException e){
        log.info("业务异常：{}",e.getMessage());
        return Result.error(e.getMessage());
    }

}























































