package site.hansi.jiacraft.module.mp.dal.mysql.message;

import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.framework.mybatis.core.mapper.BaseMapperX;
import site.hansi.jiacraft.framework.mybatis.core.query.LambdaQueryWrapperX;
import site.hansi.jiacraft.module.mp.controller.admin.message.vo.message.MpMessagePageReqVO;
import site.hansi.jiacraft.module.mp.dal.dataobject.message.MpMessageDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MpMessageMapper extends BaseMapperX<MpMessageDO> {

    default PageResult<MpMessageDO> selectPage(MpMessagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MpMessageDO>()
                .eqIfPresent(MpMessageDO::getAccountId, reqVO.getAccountId())
                .eqIfPresent(MpMessageDO::getType, reqVO.getType())
                .eqIfPresent(MpMessageDO::getOpenid, reqVO.getOpenid())
                .eqIfPresent(MpMessageDO::getUserId, reqVO.getUserId())
                .betweenIfPresent(MpMessageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MpMessageDO::getId));
    }

}
