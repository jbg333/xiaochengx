package com.jia.weixin.feign.loginpage;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weixin.util.Rt;
import com.weixin.vo.Person;
import com.weixin.vo.StandingBook;

public interface ILoginPage {
	/**
	 * 登录接口
	 * @param person
	 * @return
	 */
	@RequestMapping(value = { "/login" }, method = {RequestMethod.POST})
	public Rt<List<Person>> login(@RequestBody Person person);
	
	/**
	 * 查询用户 记账记录
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = { "/info/{userId}" }, method = {RequestMethod.GET})
	public Rt<List<StandingBook>> getUserList(@PathVariable("userId")  Long userId);
	
	
	/**
	 * 标记为已还
	 * @param userId
	 * @param rowId
	 * @return
	 */
	@RequestMapping(value = { "/upt/{userId}/{rowId}" }, method = {RequestMethod.PUT})
	public Rt<String> markRepay(@PathVariable("userId")  Long userId ,@PathVariable("rowId") Long rowId);
	
	
	/**
	 * 保存一条记账记录
	 * @param book
	 * @return
	 */
	@RequestMapping(value = { "/save" }, method = {RequestMethod.POST})
	public Rt<String> saveBook(@RequestBody StandingBook book);
}
