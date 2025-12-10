package site.hansi.jiacraft.framework.idempotent.config;

import site.hansi.jiacraft.framework.idempotent.core.aop.IdempotentAspect;
import site.hansi.jiacraft.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import site.hansi.jiacraft.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import site.hansi.jiacraft.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import site.hansi.jiacraft.framework.idempotent.core.keyresolver.impl.UserIdempotentKeyResolver;
import site.hansi.jiacraft.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import site.hansi.jiacraft.framework.redis.config.JiacraftRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = JiacraftRedisAutoConfiguration.class)
public class JiacraftIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public UserIdempotentKeyResolver userIdempotentKeyResolver() {
        return new UserIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
