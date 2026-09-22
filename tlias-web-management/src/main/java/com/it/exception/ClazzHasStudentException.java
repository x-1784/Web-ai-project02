package com.it.exception;

/**
 * 自定义异常：班级下关联了学生时，不允许删除班级
 */
public class ClazzHasStudentException extends RuntimeException {

    public ClazzHasStudentException(String message) {
        super(message);
    }
}

