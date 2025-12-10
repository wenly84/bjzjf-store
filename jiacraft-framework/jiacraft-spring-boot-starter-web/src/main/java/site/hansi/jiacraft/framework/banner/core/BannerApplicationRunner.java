package site.hansi.jiacraft.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author 北京智匠坊
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                     "----------------------------------------------------------");


            // 工作流
            if (isNotPresent("site.hansi.jiacraft.module.bpm.framework.flowable.config.BpmFlowableConfiguration")) {
                System.out.println("[工作流模块 jiacraft-module-bpm - 已禁用][参考 https://doc.iocoder.cn/bpm/ 开启]");
            }
            // 商城系统
            if (isNotPresent("site.hansi.jiacraft.module.trade.framework.web.config.TradeWebConfiguration")) {
                System.out.println("[商城系统 jiacraft-module-mall - 已禁用][参考 https://doc.iocoder.cn/mall/build/ 开启]");
            }
            // 微信公众号
            if (isNotPresent("site.hansi.jiacraft.module.mp.framework.mp.config.MpConfiguration")) {
                System.out.println("[微信公众号 jiacraft-module-mp - 已禁用][参考 https://doc.iocoder.cn/mp/build/ 开启]");
            }
            // 支付平台
            if (isNotPresent("site.hansi.jiacraft.module.pay.framework.pay.config.PayConfiguration")) {
                System.out.println("[支付系统 jiacraft-module-pay - 已禁用][参考 https://doc.iocoder.cn/pay/build/ 开启]");
            }
            // AI 大模型
            if (isNotPresent("site.hansi.jiacraft.module.ai.framework.web.config.AiWebConfiguration")) {
                System.out.println("[AI 大模型 jiacraft-module-ai - 已禁用][参考 https://doc.iocoder.cn/ai/build/ 开启]");
            }
        });
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }

}
