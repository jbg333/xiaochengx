package com.jia.code.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	

	@RequestMapping("/index")
	public String list() {
		System.out.println("跳转主界面");
		return "gen/list";
	}
}
