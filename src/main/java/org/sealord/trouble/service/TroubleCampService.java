package org.sealord.trouble.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.sealord.framework.mybatis.pojo.PageParam;
import org.sealord.trouble.domain.TroubleCamp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author goodliu
* @description 针对表【trouble_camp】的数据库操作Service
* @createDate 2024-04-10 09:27:49
*/
public interface TroubleCampService extends IService<TroubleCamp> {

    /**
     * 分页查询
     */
    IPage<TroubleCamp> queryTroubleOnPage(PageParam pageParam);
}
