package site.hansi.jiacraft.module.member.controller.admin.config;

import site.hansi.jiacraft.framework.common.pojo.CommonResult;
import site.hansi.jiacraft.module.member.controller.admin.config.vo.MemberConfigRespVO;
import site.hansi.jiacraft.module.member.controller.admin.config.vo.MemberConfigSaveReqVO;
import site.hansi.jiacraft.module.member.convert.config.MemberConfigConvert;
import site.hansi.jiacraft.module.member.dal.dataobject.config.MemberConfigDO;
import site.hansi.jiacraft.module.member.service.config.MemberConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import static site.hansi.jiacraft.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 会员设置")
@RestController
@RequestMapping("/member/config")
@Validated
public class MemberConfigController {

    @Resource
    private MemberConfigService memberConfigService;

    @PutMapping("/save")
    @Operation(summary = "保存会员配置")
    @PreAuthorize("@ss.hasPermission('member:config:save')")
    public CommonResult<Boolean> saveConfig(@Valid @RequestBody MemberConfigSaveReqVO saveReqVO) {
        memberConfigService.saveConfig(saveReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得会员配置")
    @PreAuthorize("@ss.hasPermission('member:config:query')")
    public CommonResult<MemberConfigRespVO> getConfig() {
        MemberConfigDO config = memberConfigService.getConfig();
        return success(MemberConfigConvert.INSTANCE.convert(config));
    }

}
