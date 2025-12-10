package site.hansi.jiacraft.module.ai.framework.web.config;

<<<<<<< HEAD:bjzjf-module-ai/bjzjf-module-ai-biz/src/main/java/site/hansi/module/ai/framework/web/config/AiWebConfiguration.java
import org.springdoc.core.GroupedOpenApi;
=======
import site.hansi.jiacraft.framework.swagger.config.JiacraftSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
>>>>>>> master:jiacraft-module-ai/src/main/java/site/hansi/jiacraft/module/ai/framework/web/config/AiWebConfiguration.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.hansi.framework.swagger.config.BjzjfSwaggerAutoConfiguration;

/**
 * ai 模块的 web 组件的 Configuration
 *
 * @author 北京智匠坊
 */
@Configuration(proxyBeanMethods = false)
public class AiWebConfiguration {

    /**
     * ai 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi aiGroupedOpenApi() {
        return JiacraftSwaggerAutoConfiguration.buildGroupedOpenApi("ai");
    }

}
