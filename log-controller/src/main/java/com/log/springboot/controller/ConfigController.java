package com.log.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
	
	@Value("${server.port}")
    String foo;

	
	@GetMapping("/get")
	public Object getConfig() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("foo", foo);
		//dataMap.put("path", path);
		return dataMap;
	}

}
