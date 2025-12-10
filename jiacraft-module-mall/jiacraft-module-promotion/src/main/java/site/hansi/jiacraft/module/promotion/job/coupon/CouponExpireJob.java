package site.hansi.jiacraft.module.promotion.job.coupon;

import cn.hutool.core.util.StrUtil;
import site.hansi.jiacraft.framework.quartz.core.handler.JobHandler;
import site.hansi.jiacraft.framework.tenant.core.job.TenantJob;
import site.hansi.jiacraft.module.promotion.service.coupon.CouponService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

<<<<<<< HEAD:bjzjf-module-mall/bjzjf-module-promotion-biz/src/main/java/site/hansi/module/promotion/job/coupon/CouponExpireJob.java
// TODO 智匠坊：配置一个 Job
=======
>>>>>>> master:jiacraft-module-mall/jiacraft-module-promotion/src/main/java/site/hansi/jiacraft/module/promotion/job/coupon/CouponExpireJob.java
/**
 * 优惠券过期 Job
 *
 * @author owen
 */
@Component
public class CouponExpireJob implements JobHandler {

    @Resource
    private CouponService couponService;

    @Override
    @TenantJob
    public String execute(String param) {
        int count = couponService.expireCoupon();
        return StrUtil.format("过期优惠券 {} 个", count);
    }

}
