package site.hansi.jiacraft.framework.tracer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * BizTracer配置类
 *
 * @author 北京智匠坊
 */
@ConfigurationProperties("jiacraft.tracer")
@Data
public class TracerProperties {
}
