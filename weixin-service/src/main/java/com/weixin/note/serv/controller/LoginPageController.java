package com.weixin.note.serv.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.jia.weixin.feign.loginpage.ILoginPage;
import com.weixin.util.Rt;
import com.weixin.vo.Person;
import com.weixin.vo.StandingBook;
@Controller
public class LoginPageController implements ILoginPage{

	@Override
	public Rt<List<Person>> login(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rt<List<StandingBook>> getUserList(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rt<String> markRepay(Long userId, Long rowId) {
		System.out.println("===========调用Service=========="+userId+"===="+rowId+"======");
		return Rt.ok("操作成功");
	}

	@Override
	public Rt<String> saveBook(StandingBook book) {
		// TODO Auto-generated method stub
		return null;
	}

}
