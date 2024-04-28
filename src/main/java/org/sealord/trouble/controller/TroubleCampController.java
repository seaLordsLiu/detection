package org.sealord.trouble.controller;

import org.sealord.framework.mybatis.pojo.PageParam;
import org.sealord.common.pojo.Result;
import org.sealord.framework.mybatis.pojo.PageResult;
import org.sealord.trouble.service.TroubleCampService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author liu xw
 * @date 2024 04-12
 */
@RestController
@RequestMapping("/trouble-camp")
public class TroubleCampController {

    @Resource
    private TroubleCampService troubleCampService;

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public Result<?> queryTroubleOnPage(PageParam param){
        return Result.success(PageResult.of(troubleCampService.queryTroubleOnPage(param)));
    }
}