package site.hansi.jiacraft.module.infra.framework.web.config;

import site.hansi.jiacraft.framework.swagger.config.JiacraftSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author 北京智匠坊
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return JiacraftSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
