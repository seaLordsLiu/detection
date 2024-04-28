package org.sealord.api.trouble.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 故障信息记录实体类
 * @author liu xw
 * @date 2024 04-10
 */
@Data
public class TroubleApiRequest {

    /**
     * 故障代表（异常类信息）
     */
    @NotBlank(message = "未指定故障代表（异常类信息）")
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
     * 故障上报时间戳 - 秒级
     */
    private Long reportTime;

    /**
     * 自定义数据信息 - JSON格式字符串
     */
    private String customData;
}
