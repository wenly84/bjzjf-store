package site.hansi.jiacraft.module.promotion.job.combination;

import cn.hutool.core.util.StrUtil;
import site.hansi.jiacraft.framework.common.core.KeyValue;
import site.hansi.jiacraft.framework.quartz.core.handler.JobHandler;
import site.hansi.jiacraft.framework.tenant.core.job.TenantJob;
import site.hansi.jiacraft.module.promotion.service.combination.CombinationRecordService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * 拼团过期 Job
 *
 * @author 北京智匠坊
 */
@Component
public class CombinationRecordExpireJob implements JobHandler {

    @Resource
    private CombinationRecordService combinationRecordService;

    @Override
    @TenantJob
    public String execute(String param) {
        KeyValue<Integer, Integer> keyValue = combinationRecordService.expireCombinationRecord();
        return StrUtil.format("过期拼团 {} 个, 虚拟成团 {} 个", keyValue.getKey(), keyValue.getValue());
    }

}
