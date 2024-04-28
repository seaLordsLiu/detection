package org.sealord.trouble.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 故障信息类
 * @TableName trouble_camp
 */
@TableName(value ="trouble_camp")
@Data
public class TroubleCamp implements Serializable {
    /**
     * id值
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 环境标签
     */
    private String envLabel;

    /**
     * 服务名称信息
     */
    private String applicationName;

    /**
     * 故障代表（异常类信息）
     */
    private String trouble;

    /**
     * 故障内容（异常信息）
     */
    private String message;

    /**
     * 故障信息（异常栈堆）
     */
    private String information;

    /**
     * custom data (json)
     */
    private String customData;

    /**
     * 故障上报时间戳 - 秒级
     */
    private Long reportTime;

    /**
     * web - request url
     */
    private String url;

    /**
     * web - request method
     */
    private String method;

    /**
     * web - request url param
     */
    private String urlParam;

    /**
     * web - request param (json)
     * request dateformat
     * request json
     */
    private String param;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}