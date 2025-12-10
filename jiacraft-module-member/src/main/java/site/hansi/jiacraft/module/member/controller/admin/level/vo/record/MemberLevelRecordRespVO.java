package site.hansi.jiacraft.module.member.controller.admin.level.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 会员等级记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberLevelRecordRespVO extends MemberLevelRecordBaseVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "8741")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

<<<<<<< HEAD:bjzjf-module-mall/bjzjf-module-trade-biz/src/main/java/site/hansi/module/trade/controller/admin/brokerage/vo/withdraw/BrokerageWithdrawRespVO.java
    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "智匠坊")
    private String userNickname;

=======
>>>>>>> master:jiacraft-module-member/src/main/java/site/hansi/jiacraft/module/member/controller/admin/level/vo/record/MemberLevelRecordRespVO.java
}
