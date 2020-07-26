package com.mong.cmmn;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.mong.cmmn.response.JsonResponse;

import egovframework.rte.fdl.cmmn.exception.BaseException;

public class Common {
	private static Logger log = Logger.getLogger(Common.class);
	
	public static final String SUCCESS = "0";
	public static final String ERROR = "1";
	
	public static void outWrite(JSONObject json, HttpServletResponse response, String resultCode, String resultMsg,
			String title) throws JSONException, IOException {
		if (json == null) {
			json = new JSONObject();
		}

		json.put("resultCode", resultCode);
		json.put("resultMsg", resultMsg);

		log.info("========================== " + (title == null ? "(empty)" : title) + " ======================");
		log.info(json);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(json.toString());
	}

	public static void outWrite(JsonResponse jsonResponse, HttpServletResponse response) throws BaseException {
		try {
			outWrite(jsonResponse.getJsonObject(), response, jsonResponse.getResultCode(), jsonResponse.getResultMsg(),
					jsonResponse.getTitle());
		} catch (JSONException | IOException e) {
			throw new BaseException(e);
		}
	}

	public static void outSSLWrite(JSONObject json, String callback, HttpServletResponse response, String resultCode,
			String resultMsg, String title) throws IOException, JSONException {
		if (json == null) {
			json = new JSONObject();
		}

		json.put("resultCode", resultCode);
		json.put("resultMsg", resultMsg);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(callback + "(" + json.toString() + ")");
	}

	public static void outWrite(HttpServletResponse response, String text) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");

		response.getWriter().write(text);
	}

	public static void outAlertMove(HttpServletResponse response, String text, String url) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");

		String script = String.format(
				"<!DOCTYPE html><html lang=\"ko\"><head><meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\" /><script type=\"text/javascript\">alert('%s'); location.href=\"%s\";</script></head><body></body></html>",
				text, url);

		response.getWriter().write(script);
	}

	public static void outAlertClose(HttpServletResponse response, String text) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");

		String script = String.format(
				"<!DOCTYPE html><html lang=\"ko\"><head><meta http-equiv=\"Content-Type\"  content=\"text/html; charset=utf-8\" /><script type=\"text/javascript\">alert('%s'); self.close();</script></head><body></body></html>",
				text);

		response.getWriter().write(script);
		response.getWriter().flush();
		response.getWriter().close();
	}

}
