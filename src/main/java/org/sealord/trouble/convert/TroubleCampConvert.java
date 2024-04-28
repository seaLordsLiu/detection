package org.sealord.trouble.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sealord.api.trouble.vo.TroubleApiRequest;
import org.sealord.api.trouble.vo.WebTroubleApiRequest;
import org.sealord.trouble.domain.TroubleCamp;

/**
 * @author liu xw
 * @date 2024 04-10
 */
@Mapper
public interface TroubleCampConvert {

    TroubleCampConvert INSTANCE = Mappers.getMapper(TroubleCampConvert.class);


    @Mapping(target = "urlParam", ignore = true)
    @Mapping(target = "url", ignore = true)
    @Mapping(target = "param", ignore = true)
    @Mapping(target = "method", ignore = true)
    @Mapping(target = "id", ignore = true)
    TroubleCamp toDO(TroubleApiRequest source, String applicationName, String envLabel);


    @Mapping(target = "id", ignore = true)
    TroubleCamp toDO(WebTroubleApiRequest source, String applicationName, String envLabel);

}
