package site.hansi.jiacraft.module.bpm.service.oa.listener;

import site.hansi.jiacraft.module.bpm.api.event.BpmProcessInstanceStatusEvent;
import site.hansi.jiacraft.module.bpm.api.event.BpmProcessInstanceStatusEventListener;
import site.hansi.jiacraft.module.bpm.service.oa.BpmOALeaveService;
import site.hansi.jiacraft.module.bpm.service.oa.BpmOALeaveServiceImpl;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * OA 请假单的结果的监听器实现类
 *
 * @author 北京智匠坊
 */
@Component
public class BpmOALeaveStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private BpmOALeaveService leaveService;

    @Override
    protected String getProcessDefinitionKey() {
        return BpmOALeaveServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceStatusEvent event) {
        leaveService.updateLeaveStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
