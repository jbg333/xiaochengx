package com.weixin.note.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weixin.note.api.service.IApiLoginPage;
import com.weixin.util.Rt;
import com.weixin.vo.Person;
import com.weixin.vo.StandingBook;

@RestController
@RequestMapping("/v1")
public class StandingBookController {
	
	@Autowired
	private IApiLoginPage apiLoginPage;
	
	@RequestMapping("/test/{name}")
	public String testApi(@PathVariable("name") String name) {
		System.out.println(name);
		//apiLoginPage.markRepay(100l, 99l);
		Rt<List<StandingBook>> rt = apiLoginPage.getUserList(101l);
		Person p = new Person();
		p.setAge(100);
		p.setName("贾彬国");
		apiLoginPage.login(p);
		apiLoginPage.deltest(8l, 9l,10l);
		return "调用成功(为什么不成功)";
	}

}
