package site.hansi.jiacraft.module.ai.framework.web.config;

import site.hansi.jiacraft.framework.swagger.config.JiacraftSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
