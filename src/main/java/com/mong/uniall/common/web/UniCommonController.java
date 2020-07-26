package com.mong.uniall.common.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mong.cmmn.Common;
import com.mong.cmmn.page.request.UniRequest;
import com.mong.uniall.base.web.UniBaseController;

@Controller
public class UniCommonController extends UniBaseController {
	
	static Logger log = Logger.getLogger(UniCommonController.class);

	@RequestMapping(value="/ajax/certSend.do")
	public @ResponseBody void certSend(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		setNewMessage(model);
		setNewJsonResponse();
		
		Map<String, Object> body = UniRequest.getParameterMap(request);
		putJsonObjectValue("body", body);

		Common.outWrite(getJsonResponse(), response);
	}
}
