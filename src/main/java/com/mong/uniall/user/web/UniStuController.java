package com.mong.uniall.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/stu")
public class UniStuController {

	@RequestMapping(value="/login.do")
	public String login(HttpServletRequest request, ModelMap model) throws Exception {
		
		return "stu/login";
	}
}
