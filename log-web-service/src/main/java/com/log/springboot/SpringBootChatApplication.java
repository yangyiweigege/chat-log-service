package com.log.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

/**
 * 注意事项  读取的yml文件结构为/{application}-{profile}.yml /bus/refresh 刷新所有消息总线
 * 本项目为config-client-dev.yml
 * @author yangyiwei
 * @date 2018年5月29日
 * @time 下午2:32:43
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}) // spring-boot 启动类
@ComponentScan(basePackages = { "com.log.springboot" }) // 基本扫包配置
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//发现服务
@EnableFeignClients//声明为feign
@EnableHystrixDashboard//监控断路情况
@EnableHystrix 
public class SpringBootChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootChatApplication.class, args);
	}
}
