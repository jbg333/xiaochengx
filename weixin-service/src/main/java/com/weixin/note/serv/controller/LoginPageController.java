package com.weixin.note.serv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jia.weixin.feign.loginpage.ILoginPage;
import com.weixin.util.Rt;
import com.weixin.vo.Person;
import com.weixin.vo.StandingBook;
@RestController
public class LoginPageController implements ILoginPage{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Rt<List<Person>> login(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/info/{userId}" }, method = {RequestMethod.GET})
	public Rt<List<StandingBook>> getUserList(@PathVariable("userId") Long userId) {
		System.out.println("===========调用Service=========="+userId+"======");
		logger.info("测试日志{a}={b}", userId);
		return Rt.error("调用失败");
	}

	@Override
	public Rt<String> markRepay(Long userId, Long rowId) {
		System.out.println("===========调用Service=========="+userId+"===="+rowId+"======");
		logger.info("测试日志{a}={b}", userId,rowId);
		return Rt.ok("操作成功");
	}

	@Override
	public Rt<String> saveBook(StandingBook book) {
		// TODO Auto-generated method stub
		return null;
	}

}
