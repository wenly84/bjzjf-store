package site.hansi.jiacraft.module.ai.job.music;

<<<<<<< HEAD:bjzjf-module-ai/bjzjf-module-ai-biz/src/main/java/site/hansi/module/ai/job/music/AiSunoSyncJob.java
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import site.hansi.framework.quartz.core.handler.JobHandler;
import site.hansi.module.ai.service.music.AiMusicService;
=======
import site.hansi.jiacraft.framework.quartz.core.handler.JobHandler;
import site.hansi.jiacraft.module.ai.service.music.AiMusicService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
>>>>>>> master:jiacraft-module-ai/src/main/java/site/hansi/jiacraft/module/ai/job/music/AiSunoSyncJob.java


/**
 * 同步 Suno 任务状态以及回写对应的音乐信息 Job
 *
 * @author xiaoxin
 */
@Component
@Slf4j
public class AiSunoSyncJob implements JobHandler {

    @Resource
    private AiMusicService musicService;

    @Override
    public String execute(String param) {
        Integer count = musicService.syncMusic();
        log.info("[execute][同步 Suno ({}) 个]", count);
        return String.format("同步 Suno %s 个", count);
    }

}
