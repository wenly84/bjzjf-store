package site.hansi.jiacraft.module.member.controller.app.point;

import site.hansi.jiacraft.framework.common.pojo.CommonResult;
import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.framework.common.util.object.BeanUtils;
import site.hansi.jiacraft.module.member.controller.app.point.vo.AppMemberPointRecordPageReqVO;
import site.hansi.jiacraft.module.member.controller.app.point.vo.AppMemberPointRecordRespVO;
import site.hansi.jiacraft.module.member.dal.dataobject.point.MemberPointRecordDO;
import site.hansi.jiacraft.module.member.service.point.MemberPointRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static site.hansi.jiacraft.framework.common.pojo.CommonResult.success;
import static site.hansi.jiacraft.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "用户 App - 签到记录")
@RestController
@RequestMapping("/member/point/record")
@Validated
public class AppMemberPointRecordController {

    @Resource
    private MemberPointRecordService pointRecordService;

    @GetMapping("/page")
    @Operation(summary = "获得用户积分记录分页")
    public CommonResult<PageResult<AppMemberPointRecordRespVO>> getPointRecordPage(
            @Valid AppMemberPointRecordPageReqVO pageReqVO) {
        PageResult<MemberPointRecordDO> pageResult = pointRecordService.getPointRecordPage(getLoginUserId(), pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppMemberPointRecordRespVO.class));
    }

}
