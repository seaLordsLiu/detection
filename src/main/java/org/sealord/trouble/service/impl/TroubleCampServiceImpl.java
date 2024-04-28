package org.sealord.trouble.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.sealord.api.trouble.service.TroubleCampApiService;
import org.sealord.api.trouble.vo.TroubleApiRequest;
import org.sealord.api.trouble.vo.WebTroubleApiRequest;
import org.sealord.framework.mybatis.pojo.PageParam;
import org.sealord.trouble.convert.TroubleCampConvert;
import org.sealord.trouble.domain.TroubleCamp;
import org.sealord.trouble.mapper.TroubleCampMapper;
import org.sealord.trouble.service.TroubleCampService;
import org.springframework.stereotype.Service;

/**
* @author goodliu
* @description 针对表【trouble_camp】的数据库操作Service实现
* @createDate 2024-04-10 09:27:49
*/
@Service
public class TroubleCampServiceImpl extends ServiceImpl<TroubleCampMapper, TroubleCamp>
    implements TroubleCampService, TroubleCampApiService {

    @Override
    public IPage<TroubleCamp> queryTroubleOnPage(PageParam pageParam) {
        return super.lambdaQuery()
            .page(Page.of(pageParam.getPageNo(), pageParam.getPageSize()));
    }

    @Override
    public boolean insert(TroubleApiRequest api, String applicationName, String evnLabel) {
        return super.save(TroubleCampConvert.INSTANCE.toDO(api, applicationName, evnLabel));
    }

    @Override
    public boolean insertOnWeb(WebTroubleApiRequest api, String applicationName, String evnLabel) {
        return super.save(TroubleCampConvert.INSTANCE.toDO(api, applicationName, evnLabel));
    }
}




