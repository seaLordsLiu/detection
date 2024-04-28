package org.sealord.framework.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页参数
 * @author liu xw
 * @date 2024 04-12
 */
@Data
public class PageParam implements Serializable {


    private Integer pageNo;


    private Integer pageSize;
}
