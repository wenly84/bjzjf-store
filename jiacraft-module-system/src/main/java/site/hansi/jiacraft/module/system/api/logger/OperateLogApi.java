package site.hansi.jiacraft.module.system.api.logger;

import site.hansi.jiacraft.framework.common.biz.system.logger.OperateLogCommonApi;
import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.module.system.api.logger.dto.OperateLogPageReqDTO;
import site.hansi.jiacraft.module.system.api.logger.dto.OperateLogRespDTO;

/**
 * 操作日志 API 接口
 *
 * @author 北京智匠坊
 */
public interface OperateLogApi extends OperateLogCommonApi {

    /**
     * 获取指定模块的指定数据的操作日志分页
     *
     * @param pageReqDTO 请求
     * @return 操作日志分页
     */
    PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO);

}
