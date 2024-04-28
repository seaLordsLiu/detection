package org.sealord.api.trouble.service;

import org.sealord.api.trouble.vo.TroubleApiRequest;
import org.sealord.api.trouble.vo.WebTroubleApiRequest;


/**
 * @author liu xw
 * @date 2024 04-21
 */
public interface TroubleCampApiService {

    /**
     * 添加设备信息
     * @param api 参数
     * @param applicationName 服务名称
     * @param evnLabel 环境信息
     * @return 结果
     */
    boolean insert(TroubleApiRequest api, String applicationName, String evnLabel);


    /**
     * 添加设备信息
     * @param api 参数
     * @param applicationName 服务名称
     * @param evnLabel 环境信息
     * @return 结果
     */
    boolean insertOnWeb(WebTroubleApiRequest api, String applicationName, String evnLabel);
}
