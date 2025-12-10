package site.hansi.jiacraft.module.pay.convert.wallet;

import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.module.pay.controller.admin.wallet.vo.wallet.PayWalletRespVO;
import site.hansi.jiacraft.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import site.hansi.jiacraft.module.pay.dal.dataobject.wallet.PayWalletDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletConvert {

    PayWalletConvert INSTANCE = Mappers.getMapper(PayWalletConvert.class);

    AppPayWalletRespVO convert(PayWalletDO bean);

    PayWalletRespVO convert02(PayWalletDO bean);

    PageResult<PayWalletRespVO> convertPage(PageResult<PayWalletDO> page);

}
