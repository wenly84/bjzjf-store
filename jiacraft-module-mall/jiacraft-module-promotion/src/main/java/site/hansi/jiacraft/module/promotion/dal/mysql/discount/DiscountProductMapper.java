package site.hansi.jiacraft.module.promotion.dal.mysql.discount;

import site.hansi.jiacraft.framework.mybatis.core.mapper.BaseMapperX;
import site.hansi.jiacraft.framework.mybatis.core.query.LambdaQueryWrapperX;
import site.hansi.jiacraft.module.promotion.dal.dataobject.discount.DiscountProductDO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 限时折扣商城 Mapper
 *
 * @author 北京智匠坊
 */
@Mapper
public interface DiscountProductMapper extends BaseMapperX<DiscountProductDO> {

    default List<DiscountProductDO> selectListByActivityId(Long activityId) {
        return selectList(DiscountProductDO::getActivityId, activityId);
    }

    default List<DiscountProductDO> selectListByActivityId(Collection<Long> activityIds) {
        return selectList(DiscountProductDO::getActivityId, activityIds);
    }

    default void updateByActivityId(DiscountProductDO discountProductDO) {
        update(discountProductDO, new LambdaUpdateWrapper<DiscountProductDO>()
                .eq(DiscountProductDO::getActivityId, discountProductDO.getActivityId()));
    }

    default void deleteByActivityId(Long activityId) {
        delete(DiscountProductDO::getActivityId, activityId);
    }

    default List<DiscountProductDO> selectListBySkuIdsAndStatusAndNow(Collection<Long> skuIds, Integer status) {
        LocalDateTime now = LocalDateTime.now();
        return selectList(new LambdaQueryWrapperX<DiscountProductDO>()
                .in(DiscountProductDO::getSkuId, skuIds)
                .eq(DiscountProductDO::getActivityStatus,status)
                .lt(DiscountProductDO::getActivityStartTime, now)
                .gt(DiscountProductDO::getActivityEndTime, now));
    }

}
