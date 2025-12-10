package site.hansi.jiacraft.module.promotion.api.combination;

import site.hansi.jiacraft.framework.common.util.object.BeanUtils;
import site.hansi.jiacraft.module.promotion.api.combination.dto.CombinationRecordCreateReqDTO;
import site.hansi.jiacraft.module.promotion.api.combination.dto.CombinationRecordCreateRespDTO;
import site.hansi.jiacraft.module.promotion.api.combination.dto.CombinationRecordRespDTO;
import site.hansi.jiacraft.module.promotion.api.combination.dto.CombinationValidateJoinRespDTO;
import site.hansi.jiacraft.module.promotion.convert.combination.CombinationActivityConvert;
import site.hansi.jiacraft.module.promotion.dal.dataobject.combination.CombinationRecordDO;
import site.hansi.jiacraft.module.promotion.service.combination.CombinationRecordService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 拼团活动 API 实现类
 *
 * @author 北京智匠坊
 */
@Service
@Validated
public class CombinationRecordApiImpl implements CombinationRecordApi {

    @Resource
    private CombinationRecordService combinationRecordService;

    @Override
    public void validateCombinationRecord(Long userId, Long activityId, Long headId, Long skuId, Integer count) {
        combinationRecordService.validateCombinationRecord(userId, activityId, headId, skuId, count);
    }

    @Override
    public CombinationRecordCreateRespDTO createCombinationRecord(CombinationRecordCreateReqDTO reqDTO) {
        return CombinationActivityConvert.INSTANCE.convert4(combinationRecordService.createCombinationRecord(reqDTO));
    }

    @Override
    public CombinationRecordRespDTO getCombinationRecordByOrderId(Long userId, Long orderId) {
        CombinationRecordDO record = combinationRecordService.getCombinationRecord(userId, orderId);
        return BeanUtils.toBean(record, CombinationRecordRespDTO.class);
    }

    @Override
    public CombinationValidateJoinRespDTO validateJoinCombination(Long userId, Long activityId, Long headId, Long skuId, Integer count) {
        return combinationRecordService.validateJoinCombination(userId, activityId, headId, skuId, count);
    }

}
