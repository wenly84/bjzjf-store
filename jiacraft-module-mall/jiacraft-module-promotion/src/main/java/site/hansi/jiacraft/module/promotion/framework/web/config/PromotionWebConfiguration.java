package site.hansi.jiacraft.module.promotion.framework.web.config;

import site.hansi.jiacraft.framework.swagger.config.JiacraftSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * promotion 模块的 web 组件的 Configuration
 *
 * @author 北京智匠坊
 */
@Configuration(proxyBeanMethods = false)
public class PromotionWebConfiguration {

    /**
     * promotion 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi promotionGroupedOpenApi() {
        return JiacraftSwaggerAutoConfiguration.buildGroupedOpenApi("promotion");
    }

}
