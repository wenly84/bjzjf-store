package site.hansi.jiacraft.module.member.controller.app.level;

import site.hansi.jiacraft.framework.common.pojo.CommonResult;
import site.hansi.jiacraft.framework.common.pojo.PageParam;
import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.module.member.controller.app.level.vo.experience.AppMemberExperienceRecordRespVO;
import site.hansi.jiacraft.module.member.convert.level.MemberExperienceRecordConvert;
import site.hansi.jiacraft.module.member.dal.dataobject.level.MemberExperienceRecordDO;
import site.hansi.jiacraft.module.member.service.level.MemberExperienceRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import static site.hansi.jiacraft.framework.common.pojo.CommonResult.success;
import static site.hansi.jiacraft.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "用户 App - 会员经验记录")
@RestController
@RequestMapping("/member/experience-record")
@Validated
public class AppMemberExperienceRecordController {

    @Resource
    private MemberExperienceRecordService experienceLogService;

    @GetMapping("/page")
    @Operation(summary = "获得会员经验记录分页")
    public CommonResult<PageResult<AppMemberExperienceRecordRespVO>> getExperienceRecordPage(
            @Valid PageParam pageParam) {
        PageResult<MemberExperienceRecordDO> pageResult = experienceLogService.getExperienceRecordPage(
                getLoginUserId(), pageParam);
        return success(MemberExperienceRecordConvert.INSTANCE.convertPage02(pageResult));
    }

}
