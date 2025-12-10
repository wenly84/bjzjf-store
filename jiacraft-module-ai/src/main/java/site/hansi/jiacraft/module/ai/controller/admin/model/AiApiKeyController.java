package site.hansi.jiacraft.module.ai.controller.admin.model;

<<<<<<< HEAD:bjzjf-module-ai/bjzjf-module-ai-biz/src/main/java/site/hansi/module/ai/controller/admin/model/AiApiKeyController.java
import static site.hansi.framework.common.pojo.CommonResult.success;
import static site.hansi.framework.common.util.collection.CollectionUtils.convertList;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import site.hansi.framework.common.pojo.CommonResult;
import site.hansi.framework.common.pojo.PageResult;
import site.hansi.framework.common.util.object.BeanUtils;
import site.hansi.module.ai.controller.admin.model.vo.apikey.AiApiKeyPageReqVO;
import site.hansi.module.ai.controller.admin.model.vo.apikey.AiApiKeyRespVO;
import site.hansi.module.ai.controller.admin.model.vo.apikey.AiApiKeySaveReqVO;
import site.hansi.module.ai.controller.admin.model.vo.chatModel.AiChatModelRespVO;
import site.hansi.module.ai.dal.dataobject.model.AiApiKeyDO;
import site.hansi.module.ai.service.model.AiApiKeyService;
=======
import site.hansi.jiacraft.framework.common.pojo.CommonResult;
import site.hansi.jiacraft.framework.common.pojo.PageResult;
import site.hansi.jiacraft.framework.common.util.object.BeanUtils;
import site.hansi.jiacraft.module.ai.controller.admin.model.vo.apikey.AiApiKeyPageReqVO;
import site.hansi.jiacraft.module.ai.controller.admin.model.vo.apikey.AiApiKeyRespVO;
import site.hansi.jiacraft.module.ai.controller.admin.model.vo.apikey.AiApiKeySaveReqVO;
import site.hansi.jiacraft.module.ai.controller.admin.model.vo.model.AiModelRespVO;
import site.hansi.jiacraft.module.ai.dal.dataobject.model.AiApiKeyDO;
import site.hansi.jiacraft.module.ai.service.model.AiApiKeyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static site.hansi.jiacraft.framework.common.pojo.CommonResult.success;
import static site.hansi.jiacraft.framework.common.util.collection.CollectionUtils.convertList;
>>>>>>> master:jiacraft-module-ai/src/main/java/site/hansi/jiacraft/module/ai/controller/admin/model/AiApiKeyController.java

@Tag(name = "管理后台 - AI API 密钥")
@RestController
@RequestMapping("/ai/api-key")
@Validated
public class AiApiKeyController {

    @Resource
    private AiApiKeyService apiKeyService;

    @PostMapping("/create")
    @Operation(summary = "创建 API 密钥")
    @PreAuthorize("@ss.hasPermission('ai:api-key:create')")
    public CommonResult<Long> createApiKey(@Valid @RequestBody AiApiKeySaveReqVO createReqVO) {
        return success(apiKeyService.createApiKey(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新 API 密钥")
    @PreAuthorize("@ss.hasPermission('ai:api-key:update')")
    public CommonResult<Boolean> updateApiKey(@Valid @RequestBody AiApiKeySaveReqVO updateReqVO) {
        apiKeyService.updateApiKey(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除 API 密钥")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('ai:api-key:delete')")
    public CommonResult<Boolean> deleteApiKey(@RequestParam("id") Long id) {
        apiKeyService.deleteApiKey(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得 API 密钥")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:api-key:query')")
    public CommonResult<AiApiKeyRespVO> getApiKey(@RequestParam("id") Long id) {
        AiApiKeyDO apiKey = apiKeyService.getApiKey(id);
        return success(BeanUtils.toBean(apiKey, AiApiKeyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得 API 密钥分页")
    @PreAuthorize("@ss.hasPermission('ai:api-key:query')")
    public CommonResult<PageResult<AiApiKeyRespVO>> getApiKeyPage(@Valid AiApiKeyPageReqVO pageReqVO) {
        PageResult<AiApiKeyDO> pageResult = apiKeyService.getApiKeyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiApiKeyRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "获得 API 密钥分页列表")
    public CommonResult<List<AiModelRespVO>> getApiKeySimpleList() {
        List<AiApiKeyDO> list = apiKeyService.getApiKeyList();
        return success(convertList(list, key -> new AiModelRespVO().setId(key.getId()).setName(key.getName())));
    }

}