package site.hansi.jiacraft.module.bpm.framework.flowable.core.candidate.strategy.user;

import site.hansi.jiacraft.framework.common.util.string.StrUtils;
import site.hansi.jiacraft.module.bpm.dal.dataobject.definition.BpmUserGroupDO;
import site.hansi.jiacraft.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import site.hansi.jiacraft.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import site.hansi.jiacraft.module.bpm.service.definition.BpmUserGroupService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static site.hansi.jiacraft.framework.common.util.collection.CollectionUtils.convertSetByFlatMap;

/**
 * 用户组 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateGroupStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private BpmUserGroupService userGroupService;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.USER_GROUP;
    }

    @Override
    public void validateParam(String param) {
        Set<Long> groupIds = StrUtils.splitToLongSet(param);
        userGroupService.validUserGroups(groupIds);
    }

    @Override
    public Set<Long> calculateUsers(String param) {
        Set<Long> groupIds = StrUtils.splitToLongSet(param);
        List<BpmUserGroupDO> groups = userGroupService.getUserGroupList(groupIds);
        return convertSetByFlatMap(groups, BpmUserGroupDO::getUserIds, Collection::stream);
    }

}