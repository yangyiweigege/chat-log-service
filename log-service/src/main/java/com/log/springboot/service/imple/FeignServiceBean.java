package com.log.springboot.service.imple;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.log.springboot.service.FeignService;

@Service
public class FeignServiceBean implements FeignService {

	private JSONObject CommonError() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 500);
		jsonObject.put("message", "服务暂时无法接通");
		return jsonObject;
	}

	@Override
	public JSONObject findUserList(Integer pageSize) {
		return CommonError();
	}

	@Override
	public JSONObject sendGetRequest(String id) {
		return CommonError();
	}

	@Override
	public JSONObject sendPostRequest(String id) {
		return CommonError();
	}

	@Override
	public JSONObject sendJSONRequest(JSONObject jsonObject) {
		return CommonError();
	}

}
