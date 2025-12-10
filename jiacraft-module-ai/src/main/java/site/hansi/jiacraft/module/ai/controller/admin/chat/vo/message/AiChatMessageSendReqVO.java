package site.hansi.jiacraft.module.ai.controller.admin.chat.vo.message;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
<<<<<<< HEAD:bjzjf-module-ai/bjzjf-module-ai-biz/src/main/java/site/hansi/module/ai/controller/admin/chat/vo/message/AiChatMessageSendReqVO.java
import lombok.Data;
=======
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
>>>>>>> master:jiacraft-module-ai/src/main/java/site/hansi/jiacraft/module/ai/controller/admin/chat/vo/message/AiChatMessageSendReqVO.java

@Schema(description = "管理后台 - AI 聊天消息发送 Request VO")
@Data
public class AiChatMessageSendReqVO {

    @Schema(description = "聊天对话编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "聊天对话编号不能为空")
    private Long conversationId;

    @Schema(description = "聊天内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "帮我写个 Java 算法")
    @NotEmpty(message = "聊天内容不能为空")
    private String content;

    @Schema(description = "是否携带上下文", example = "true")
    private Boolean useContext;

    @Schema(description = "是否联网搜索", example = "true")
    private Boolean useSearch;

    @Schema(description = "附件 URL 数组", example = "https://www.iocoder.cn/1.png")
    private List<String> attachmentUrls;

}
