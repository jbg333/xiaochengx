package com.weixin.note.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weixin.note.api.service.IApiLoginPage;

@RestController
@RequestMapping("/v1")
public class StandingBookController {
	
	@Autowired
	private IApiLoginPage apiLoginPage;
	
	@RequestMapping("/test/{name}")
	public String testApi(@PathVariable("name") String name) {
		System.out.println(name);
		apiLoginPage.markRepay(100l, 99l);
		return "调用成功(为什么不成功)";
	}

}
