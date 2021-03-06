package com.log.springboot.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




/**
 * <pre>
 * 功       能: spring-boot 拦截器
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年4月2日 下午9:22:52
 * Q    Q: 2873824885
 * </pre>
 */
@Configuration
public class WebMvcInterceptor extends WebMvcConfigurerAdapter {

	
	
	/**
	 * {@inheritDoc}
	 * <p>This implementation is empty.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**");//注册session校验
	//	registry.addInterceptor(new ValidateAttributeInterceptor()).addPathPatterns("/**");//注册属性校验
		//registry.addInterceptor(new ValidatePageInterceptor()).addPathPatterns("/**"); //注册分页
		super.addInterceptors(registry);//注册该拦截器
	}
	
}
