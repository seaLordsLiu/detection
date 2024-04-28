package org.sealord.framework.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.sealord.common.exception.ServiceException;
import org.sealord.common.pojo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 异常处理
 * @author liu xw
 * @date 2024 04-12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理 Validated 检测异常信息
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<?> constraintViolationException(ConstraintViolationException e){
        log.error("[constraintViolationException]", e);
        ConstraintViolation<?> constraintViolation = e.getConstraintViolations().iterator().next();
        return Result.toResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), String.format("请求参数不正确:%s", constraintViolation.getMessage()), null);
    }

    /**
     * 业务逻辑兜底处理
     */
    @ExceptionHandler(ServiceException.class)
    public Result<?> serviceException(ServiceException e){
        log.error("[serviceException]", e);
        return Result.toResult(HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 全局异常兜底处理
     */
    @ExceptionHandler(Exception.class)
    public Result<?> defaultException(Exception e){
        log.error("defaultException. exception: {}. msg: {}", e.getClass().getSimpleName(), e.getMessage(), e);
        return Result.toResult(HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
}
