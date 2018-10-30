package com.log.springboot.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.fastjson.JSONObject;
import com.log.springboot.service.imple.FeignServiceBean;

/**
 * feign调用
 * 
 * @author yangyiwei
 * @date 2018年9月6日
 * @time 下午5:23:33
 */
@FeignClient(value = "chat-user-service", fallback = FeignServiceBean.class)
public interface FeignService {

	/**
	 * 返回用户列表数据
	 * 
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/mybatis/list/{currentPage}")
	public JSONObject findUserList(@PathVariable("currentPage") Integer currentPage);

	@RequestMapping(value = "/api/get")
	public JSONObject sendGetRequest(@RequestParam("id") String id);

	@RequestMapping(value = "/api/post")
	public JSONObject sendPostRequest(@RequestParam("id") String id);

	@RequestMapping(value = "/api/json")
	public JSONObject sendJSONRequest(@RequestBody JSONObject jsonObject);

}
