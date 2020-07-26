package com.mong.uniall.base.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ui.ModelMap;

import com.mong.cmmn.response.JsonResponse;
import com.mong.cmmn.util.MapUtil;

import egovframework.rte.fdl.cmmn.exception.BaseException;

public class UniBaseController {

	private Logger logger = Logger.getLogger(UniBaseController.class);
	private JsonResponse jsonResponse;

	private Map<String,Object> message;

	private Map<String, Object> resultMap;
	
	public JsonResponse getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(JsonResponse jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

	public Map<String, Object> getMessage() {
		return message;
	}

	public void setMessage(Map<String, Object> message) {
		this.message = message;
	}

	protected void setNewJsonResponse() {
		JsonResponse jsonResponse = new JsonResponse();

		jsonResponse.setJsonObject(new JSONObject());

		setJsonResponse(jsonResponse);
	}

	protected void putJsonObjectValue(String key, Collection<?> value) throws BaseException {
		try {
			getJsonResponse().getJsonObject().put(key, value);
		} catch (JSONException e) {
			throw new BaseException(e);
		}
	}

	protected void putJsonObjectValue(String key, Map<?, ?> value) throws BaseException {
		try {
			getJsonResponse().getJsonObject().put(key, value);
		} catch (JSONException e) {
			throw new BaseException(e);
		}
	}

	protected void putJsonObjectValue(String key, Object value) throws BaseException {
		try {
			getJsonResponse().getJsonObject().put(key, value);
		} catch (JSONException e) {
			throw new BaseException(e);
		}
	}

	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> getJsonResultList() throws BaseException {
		List<Map<String, Object>> resultList = null;

		try {
			resultList = (List<Map<String, Object>>) getJsonResponse().getJsonObject().get("resultList");
		} catch (JSONException e) {
			throw new BaseException(e);
		}

		return resultList;
	}

	protected void setNewMessage(ModelMap model) {
		setMessage(new HashMap<String, Object>());

		model.addAttribute("message", getMessage());
	}

	protected void setNewMessageIfNull(ModelMap model) {
		Map<String, Object> message = (Map<String, Object>) model.get("message");

		if (MapUtil.isEmpty(message)) {
			setNewMessage(model);
		}
	}
}
