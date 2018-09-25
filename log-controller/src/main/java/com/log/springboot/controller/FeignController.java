package com.log.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.log.springboot.service.FeignService;

@RestController
@RequestMapping("/feign")
public class FeignController {

	@Autowired
	private FeignService feignService;
	
	@RequestMapping("/hi")
	public JSONObject getHi(String name) {
		return feignService.getHi(name);
	}
}
