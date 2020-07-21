package com.mong.uniall.index.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UniIndexController {
	
	static Logger log = Logger.getLogger(UniIndexController.class);

	@RequestMapping(value = "/index.do")
	public String index() {
		log.info("============== index ============");
		return "index";
	}
}
