package com.weixin.note.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weixin.note.api.service.IApiLoginPage;
import com.weixin.util.Rt;
import com.weixin.vo.Person;
import com.weixin.vo.StandingBook;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1")
public class StandingBookController {
	
	@Autowired
	private IApiLoginPage apiLoginPage;
	
	@Autowired
	private RestTemplate restTemplateOut ;
	
	@ApiOperation(value="测试接口", notes="测试")
	@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "path")
	@RequestMapping("/test/{name}")
	public Person testApi(@PathVariable("name") String name) {
		
		  String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx00e5d810c8e6f47e&secret=c626013cfd82f410dc07a2fe2c43a49f";
		String add = restTemplateOut.getForObject(url, String.class);
		System.out.println(add);
		System.out.println(name);
		//apiLoginPage.markRepay(100l, 99l);
		Rt<List<StandingBook>> rt = apiLoginPage.getUserList(101l);
		Person p = new Person();
		p.setAge(100);
		p.setName("贾彬国");
		apiLoginPage.login(p);
		apiLoginPage.deltest(8l, 9l,10l);
		return p;
	}
	

	@ApiOperation(value="测试接口", notes="测试")
	@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "path")
	@RequestMapping("/test2/{name}")
	public String testApi2(@PathVariable("name") String name) {
		return "返回String";
	}

}
