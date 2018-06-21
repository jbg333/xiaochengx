package com.weixin.note.serv.controller;

import java.util.List;

import com.jia.weixin.feign.loginpage.ILoginPage;
import com.weixin.util.Rt;
import com.weixin.vo.Person;
import com.weixin.vo.StandingBook;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rt<String> saveBook(StandingBook book) {
		// TODO Auto-generated method stub
		return null;
	}

}
