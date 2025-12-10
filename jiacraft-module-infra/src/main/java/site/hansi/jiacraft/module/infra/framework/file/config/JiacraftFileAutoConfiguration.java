package site.hansi.jiacraft.module.infra.framework.file.config;

import site.hansi.jiacraft.module.infra.framework.file.core.client.FileClientFactory;
import site.hansi.jiacraft.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author 北京智匠坊
 */
@Configuration(proxyBeanMethods = false)
public class JiacraftFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
