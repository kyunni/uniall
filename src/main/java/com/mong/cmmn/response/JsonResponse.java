package com.mong.cmmn.response;

import java.io.Serializable;

import org.json.JSONObject;

public class JsonResponse implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6419379594078111421L;

	private String resultCode;
	
	private String resultMsg;
	
	private String title;
	
	private JSONObject jsonObject;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	
}
