package com.log.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chat.springboot.common.response.ResponseResult;
import com.chat.springboot.common.response.ResultStatus;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(value = "redis-controller", description = "redis控制层")
@RestController
@RequestMapping("/redis")
@Slf4j
@RefreshScope
public class RedisController {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@RequestMapping(value = "/set", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseResult<String> setString(String value) {
		log.info("获取到的string数据是:{}", value);
		redisTemplate.opsForValue().set("redis-test", value);
		return new ResponseResult<String>(ResultStatus.SUCCESS, value);
	}
}
