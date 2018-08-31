package com.weixin.note.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weixin.vo.Person;

@RestController
public class Hello {

	@RequestMapping("login")
	public String testApi(Integer num) {
		System.out.println(new Person());
		return "调用api成功"+num;
	}
}
