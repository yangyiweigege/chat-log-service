package com.log.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.log.springboot.service.FeignService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/feign")
@Slf4j
public class FeignController {

	@Autowired
	private FeignService feignService;

	@RequestMapping("/user/list/{currentPage}")
	public JSONObject getHi(@PathVariable("currentPage") Integer pageSize) {
		return feignService.findUserList(pageSize);
	}

	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	public JSONObject sendGetRequest(String id) {
		return feignService.sendGetRequest(id);
	}

	@RequestMapping(value = "/post", method = { RequestMethod.POST, RequestMethod.GET })
	public JSONObject sendPostRequest(String id) {
		JSONObject result =  feignService.sendPostRequest(id);
		return result;
	}

	@RequestMapping(value = "/json", method = { RequestMethod.POST })
	public JSONObject sendJSONRequest(@RequestBody JSONObject jsonObject, String token) {
		log.info("token:{}", token);
		return feignService.sendJSONRequest(jsonObject);
	}

}
