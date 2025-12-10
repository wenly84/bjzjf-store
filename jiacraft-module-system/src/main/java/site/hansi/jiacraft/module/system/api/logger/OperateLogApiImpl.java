package site.hansi.jiacraft.module.system.api.logger;

import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.framework.common.util.object.BeanUtils;
import site.hansi.jiacraft.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import site.hansi.jiacraft.module.system.api.logger.dto.OperateLogPageReqDTO;
import site.hansi.jiacraft.module.system.api.logger.dto.OperateLogRespDTO;
import site.hansi.jiacraft.module.system.dal.dataobject.logger.OperateLogDO;
import site.hansi.jiacraft.module.system.service.logger.OperateLogService;
import com.fhs.core.trans.anno.TransMethodResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 操作日志 API 实现类
 *
 * @author 北京智匠坊
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

    @Override
    @TransMethodResult
    public PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class);
    }

}
