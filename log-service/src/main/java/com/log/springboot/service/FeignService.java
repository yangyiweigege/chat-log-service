package com.log.springboot.service;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.fastjson.JSONObject;
import com.log.springboot.service.imple.FeignServiceBean;


/**
 * feign调用
 * @author yangyiwei
 * @date 2018年9月6日
 * @time 下午5:23:33
 */
@FeignClient(value = "service-hi", fallback = FeignServiceBean.class)
public interface FeignService {
	
	@RequestMapping("/hi")
	public JSONObject getHi(@RequestParam(value = "name") String name);
}
