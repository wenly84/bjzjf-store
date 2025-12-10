package site.hansi.jiacraft.framework.tracer.config;

import site.hansi.jiacraft.framework.common.enums.WebFilterOrderEnum;
import site.hansi.jiacraft.framework.tracer.core.filter.TraceFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Tracer 配置类
 *
 * @author 北京智匠坊
 */
@AutoConfiguration
@ConditionalOnClass(name = {
        "org.apache.skywalking.apm.toolkit.opentracing.SkywalkingTracer", // 来自 apm-toolkit-opentracing.jar
//        "io.opentracing.Tracer", // 来自 opentracing-api.jar
        "jakarta.servlet.Filter"
})
@EnableConfigurationProperties(TracerProperties.class)
@ConditionalOnProperty(prefix = "jiacraft.tracer", value = "enable", matchIfMissing = true)
public class JiacraftTracerAutoConfiguration {

<<<<<<< HEAD:bjzjf-framework/bjzjf-spring-boot-starter-monitor/src/main/java/site/hansi/framework/tracer/config/BjzjfTracerAutoConfiguration.java
    // TODO @智匠坊：重要。目前 opentracing 版本存在冲突，要么保证 skywalking，要么保证阿里云短信 sdk
//    @Bean
//    public TracerProperties bizTracerProperties() {
//        return new TracerProperties();
//    }
//
=======
    // TODO @芋艿：skywalking 不兼容最新的 opentracing 版本。同时，opentracing 也停止了维护，尬住了！后续换 opentelemetry 即可！
>>>>>>> master:jiacraft-framework/jiacraft-spring-boot-starter-monitor/src/main/java/site/hansi/jiacraft/framework/tracer/config/JiacraftTracerAutoConfiguration.java
//    @Bean
//    public BizTraceAspect bizTracingAop() {
//        return new BizTraceAspect(tracer());
//    }
//
//    @Bean
//    public Tracer tracer() {
//        // 创建 SkywalkingTracer 对象
//        SkywalkingTracer tracer = new SkywalkingTracer();
//        // 设置为 GlobalTracer 的追踪器
//        GlobalTracer.registerIfAbsent(tracer);
//        return tracer;
//    }

    /**
     * 创建 TraceFilter 过滤器，响应 header 设置 traceId
     */
    @Bean
    public FilterRegistrationBean<TraceFilter> traceFilter() {
        FilterRegistrationBean<TraceFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TraceFilter());
        registrationBean.setOrder(WebFilterOrderEnum.TRACE_FILTER);
        return registrationBean;
    }

}
