package org.sealord.api.trouble.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author liu xw
 * @date 2024 04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WebTroubleApiRequest extends TroubleApiRequest{

    /**
     * 请求URL地址信息
     */
    @NotBlank(message = "请求参数不可为空")
    private String url;

    /**
     * 请求方法
     */
    @NotBlank(message = "请求方法不可为空")
    private String method;

    /**
     * 请求参数 - url后拼接参数
     */
    private String urlParam;

    /**
     * 请求参数 - 表单/json
     * request dateformat
     * request json
     */
    private String param;
}
