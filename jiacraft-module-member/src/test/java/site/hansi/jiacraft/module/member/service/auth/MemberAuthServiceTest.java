package site.hansi.jiacraft.module.member.service.auth;

import site.hansi.jiacraft.framework.common.biz.system.oauth2.OAuth2TokenCommonApi;
import site.hansi.jiacraft.framework.common.enums.CommonStatusEnum;
import site.hansi.jiacraft.framework.common.util.collection.ArrayUtils;
import site.hansi.jiacraft.framework.redis.config.JiacraftRedisAutoConfiguration;
import site.hansi.jiacraft.framework.test.core.ut.BaseDbAndRedisUnitTest;
import site.hansi.jiacraft.module.member.dal.dataobject.user.MemberUserDO;
import site.hansi.jiacraft.module.member.dal.mysql.user.MemberUserMapper;
import site.hansi.jiacraft.module.member.service.user.MemberUserService;
import site.hansi.jiacraft.module.system.api.logger.LoginLogApi;
import site.hansi.jiacraft.module.system.api.sms.SmsCodeApi;
import site.hansi.jiacraft.module.system.api.social.SocialUserApi;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.function.Consumer;

import static cn.hutool.core.util.RandomUtil.randomEle;
import static site.hansi.jiacraft.framework.test.core.util.RandomUtils.randomPojo;
import static site.hansi.jiacraft.framework.test.core.util.RandomUtils.randomString;

// TODO @智匠坊：单测的 review，等逻辑都达成一致后
/**
 * {@link MemberAuthService} 的单元测试类
 *
 * @author 宋天
 */
@Import({MemberAuthServiceImpl.class, JiacraftRedisAutoConfiguration.class})
public class MemberAuthServiceTest extends BaseDbAndRedisUnitTest {

    // TODO @智匠坊：登录相关的单测，待补全

    @Resource
    private MemberAuthServiceImpl authService;

    @MockitoBean
    private MemberUserService userService;
    @MockitoBean
    private SmsCodeApi smsCodeApi;
    @MockitoBean
    private LoginLogApi loginLogApi;
    @MockitoBean
    private OAuth2TokenCommonApi oauth2TokenApi;
    @MockitoBean
    private SocialUserApi socialUserApi;
    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @Resource
    private MemberUserMapper memberUserMapper;

    // TODO 智匠坊：后续重构这个单测
//    @Test
//    public void testUpdatePassword_success(){
//        // 准备参数
//        MemberUserDO userDO = randomUserDO();
//        memberUserMapper.insert(userDO);
//
//        // 新密码
//        String newPassword = randomString();
//
//        // 请求实体
//        AppMemberUserUpdatePasswordReqVO reqVO = AppMemberUserUpdatePasswordReqVO.builder()
//                .oldPassword(userDO.getPassword())
//                .password(newPassword)
//                .build();
//
//        // 测试桩
//        // 这两个相等是为了返回ture这个结果
//        when(passwordEncoder.matches(reqVO.getOldPassword(),reqVO.getOldPassword())).thenReturn(true);
//        when(passwordEncoder.encode(newPassword)).thenReturn(newPassword);
//
//        // 更新用户密码
//        authService.updatePassword(userDO.getId(), reqVO);
//        assertEquals(memberUserMapper.selectById(userDO.getId()).getPassword(),newPassword);
//    }

    // TODO 智匠坊：后续重构这个单测
//    @Test
//    public void testResetPassword_success(){
//        // 准备参数
//        MemberUserDO userDO = randomUserDO();
//        memberUserMapper.insert(userDO);
//
//        // 随机密码
//        String password = randomNumbers(11);
//        // 随机验证码
//        String code = randomNumbers(4);
//
//        // mock
//        when(passwordEncoder.encode(password)).thenReturn(password);
//
//        // 更新用户密码
//        AppMemberUserResetPasswordReqVO reqVO = new AppMemberUserResetPasswordReqVO();
//        reqVO.setMobile(userDO.getMobile());
//        reqVO.setPassword(password);
//        reqVO.setCode(code);
//
//        authService.resetPassword(reqVO);
//        assertEquals(memberUserMapper.selectById(userDO.getId()).getPassword(),password);
//    }

    // ========== 随机对象 ==========

    @SafeVarargs
    private static MemberUserDO randomUserDO(Consumer<MemberUserDO>... consumers) {
        Consumer<MemberUserDO> consumer = (o) -> {
            o.setStatus(randomEle(CommonStatusEnum.values()).getStatus()); // 保证 status 的范围
            o.setPassword(randomString());
        };
        return randomPojo(MemberUserDO.class, ArrayUtils.append(consumer, consumers));
    }


}
