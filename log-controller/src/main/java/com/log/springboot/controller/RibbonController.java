package com.log.springboot.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ribbon")
@Slf4j
public class RibbonController {

	@Autowired
	private RequestUtil requestUtil;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/post")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(String name, String age) {
		log.info("已经进入到 ribbon内部");
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("age", age);
		return requestUtil.sendPostRequest("http://service-hi/post", map);
	}

	@RequestMapping("/user/detail/{id}")
	@HystrixCommand(fallbackMethod = "getUserDetailError")
	public JSONObject getUserDetail(@PathVariable("id") Integer id) {	
		return restTemplate.getForObject("http://chat-user-service/mybatis/find/detail/" + id, JSONObject.class);
	}
	
	public JSONObject getUserDetailError(Integer id) {	
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 500);
		jsonObject.put("message", "服务暂时无法接通");
		return jsonObject;
	}

	// 熔断之后 返回的错误
	public String hiError(String name, String age) {
		return "hi," + name + ",您所呼叫的服务暂时无法接通~~~~~!";
	}

}
