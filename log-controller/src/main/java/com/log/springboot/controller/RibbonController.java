package com.log.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ribbon")
@Slf4j
@Api(value = "ribbon-controller", description = "ribbon负载均衡控制层")
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	

	@RequestMapping("/user/detail/{id}")
	@HystrixCommand(fallbackMethod = "getUserDetailError")
	public JSONObject getUserDetail(@PathVariable("id") Integer id) {
		log.info("调用chat-user-service的服务......");
		return restTemplate.getForObject("http://chat-user-service/mybatis/find/detail/" + id, JSONObject.class);
	}
	
	public JSONObject getUserDetailError(Integer id) {	
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 500);
		jsonObject.put("message", "服务暂时无法接通");
		return jsonObject;
	}


}
