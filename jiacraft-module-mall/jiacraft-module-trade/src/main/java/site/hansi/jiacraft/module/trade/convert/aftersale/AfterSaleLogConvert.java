package site.hansi.jiacraft.module.trade.convert.aftersale;

import site.hansi.jiacraft.module.trade.dal.dataobject.aftersale.AfterSaleLogDO;
import site.hansi.jiacraft.module.trade.service.aftersale.bo.AfterSaleLogCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AfterSaleLogConvert {

    AfterSaleLogConvert INSTANCE = Mappers.getMapper(AfterSaleLogConvert.class);

    AfterSaleLogDO convert(AfterSaleLogCreateReqBO bean);

}
