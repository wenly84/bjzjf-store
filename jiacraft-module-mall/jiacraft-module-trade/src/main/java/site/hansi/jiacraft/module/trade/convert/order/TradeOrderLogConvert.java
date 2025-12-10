package site.hansi.jiacraft.module.trade.convert.order;

import site.hansi.jiacraft.module.trade.dal.dataobject.order.TradeOrderLogDO;
import site.hansi.jiacraft.module.trade.service.order.bo.TradeOrderLogCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TradeOrderLogConvert {

    TradeOrderLogConvert INSTANCE = Mappers.getMapper(TradeOrderLogConvert.class);

    TradeOrderLogDO convert(TradeOrderLogCreateReqBO bean);

}
