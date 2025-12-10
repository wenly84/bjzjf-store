package site.hansi.jiacraft.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 * 
 * @author 北京智匠坊
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${jiacraft.info.base-package}
@SpringBootApplication(scanBasePackages = { "${jiacraft.info.base-package}.server",
		"${jiacraft.info.base-package}.module" })
public class JiacraftServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(JiacraftServerApplication.class, args);
	}

}
