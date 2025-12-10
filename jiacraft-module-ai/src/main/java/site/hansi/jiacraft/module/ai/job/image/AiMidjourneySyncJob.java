package site.hansi.jiacraft.module.ai.job.image;

<<<<<<< HEAD:bjzjf-module-ai/bjzjf-module-ai-biz/src/main/java/site/hansi/module/ai/job/image/AiMidjourneySyncJob.java
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import site.hansi.framework.quartz.core.handler.JobHandler;
import site.hansi.module.ai.service.image.AiImageService;
=======
import site.hansi.jiacraft.framework.quartz.core.handler.JobHandler;
import site.hansi.jiacraft.module.ai.service.image.AiImageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
>>>>>>> master:jiacraft-module-ai/src/main/java/site/hansi/jiacraft/module/ai/job/image/AiMidjourneySyncJob.java

/**
 * Midjourney 同步 Job：定时拉去 midjourney 绘制状态
 *
 * @author fansili
 */
@Component
@Slf4j
public class AiMidjourneySyncJob implements JobHandler {

    @Resource
    private AiImageService imageService;

    @Override
    public String execute(String param) {
        Integer count = imageService.midjourneySync();
        log.info("[execute][同步 Midjourney ({}) 个]", count);
        return String.format("同步 Midjourney %s 个", count);
    }

}
