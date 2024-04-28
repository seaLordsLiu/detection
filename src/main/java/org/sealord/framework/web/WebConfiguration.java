package org.sealord.framework.web;

import org.sealord.framework.web.exception.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web配置中心
 * @author liu xw
 * @date 2024 04-12
 */
@Configuration(proxyBeanMethods = false)
public class WebConfiguration {


    /**
     * 全局异常处理
     * 因为 RestControllerAdvice 注解早启动类的扫描范围内, 所以这里不需要再次配置
     */
    @Bean
    @ConditionalOnMissingBean(GlobalExceptionHandler.class)
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
