package site.hansi.jiacraft.module.promotion.api.discount;

import site.hansi.jiacraft.framework.common.util.object.BeanUtils;
import site.hansi.jiacraft.module.promotion.api.discount.dto.DiscountProductRespDTO;
import site.hansi.jiacraft.module.promotion.dal.dataobject.discount.DiscountProductDO;
import site.hansi.jiacraft.module.promotion.service.discount.DiscountActivityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;

/**
 * 限时折扣 API 实现类
 *
 * @author 北京智匠坊
 */
@Service
@Validated
public class DiscountActivityApiImpl implements DiscountActivityApi {

    @Resource
    private DiscountActivityService discountActivityService;

    @Override
    public List<DiscountProductRespDTO> getMatchDiscountProductListBySkuIds(Collection<Long> skuIds) {
        List<DiscountProductDO> list = discountActivityService.getMatchDiscountProductListBySkuIds(skuIds);
        return BeanUtils.toBean(list, DiscountProductRespDTO.class);
    }

}
