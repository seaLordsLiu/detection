package org.sealord.api.trouble;

import org.sealord.api.HEADER;
import org.sealord.api.trouble.service.TroubleCampApiService;
import org.sealord.api.trouble.vo.TroubleApiRequest;
import org.sealord.api.trouble.vo.WebTroubleApiRequest;
import org.sealord.common.pojo.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 控制层
 * @author liu xw
 * @date 2024 04-10
 */
@RestController
@RequestMapping("/trouble-camp-api")
public class TroubleCampApi {

    @Resource
    private TroubleCampApiService troubleCampApiService;

    /**
     * 采集异常信息
     * @param request 请求
     * @param applicationName 服务名称
     * @param evnLabel 服务环境信息
     * @return 处理结果
     */
    @PostMapping("/receive")
    public Result<Boolean> receive(@Validated @RequestBody TroubleApiRequest request,
                                @RequestHeader(name = HEADER.X_CLIENT_NAME) String applicationName,
                                @RequestHeader(name = HEADER.X_ENV_LABEL) String evnLabel){
        return Result.success(troubleCampApiService.insert(request, applicationName, evnLabel));
    }

    /**
     * 采集异常信息
     * @param request 请求
     * @param applicationName 服务名称
     * @param evnLabel 服务环境信息
     * @return 处理结果
     */
    @PostMapping("/receive-web")
    public Result<Boolean> receiveWeb(@Validated @RequestBody WebTroubleApiRequest request,
                                   @RequestHeader(name = HEADER.X_CLIENT_NAME) String applicationName,
                                   @RequestHeader(name = HEADER.X_ENV_LABEL) String evnLabel){
        return Result.success(troubleCampApiService.insertOnWeb(request, applicationName, evnLabel));
    }


}