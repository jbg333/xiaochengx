package com.weixin.note.api.controller;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jia.weixin.feign.bill.IBillUser;
import com.weixin.entity.BillUser;
import com.weixin.note.api.service.IApiBillUser;
import com.weixin.util.Rt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 用户表
 * 
 * @author 自动生成
 * @email 402376085@qq.com
 * @date 2018-08-27 17:05:38
 */
@Api(tags = "BillUserController")
@Controller
public class BillUserController{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IApiBillUser apiBillUser;
	/**
	 * 跳转到列表页
	 */
	public String list() {
		return "billuser/list";
	}
	@ResponseBody
	public Rt<BillUser> listData(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		try {
			return apiBillUser.listData(params);
		} catch (Exception e) {
			logger.error("查询列表失败", e);
			return Rt.error("查询列表失败");
		}
	}
	/**
	 * 
	 * listDataNoPage:(不分页查询).
	 * 
	 * @author jbg
	 * @param params
	 * @return
	 * @since JDK 1.8
	 */
	@ApiOperation("列表查询不分页")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "params", value = "查询参数", required = true, dataType = "Map", paramType = "query") })
	@ApiResponses(value = {
			@ApiResponse(response = BillUser.class, responseContainer = "List", code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回") })
	@ResponseBody
	public Rt<List<BillUser>> listDataNoPage(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		return apiBillUser.listDataNoPage(params);
	}
	/**
	 * 跳转到新增页面
	 **/
	public String add() {
		return "billuser/add";
	}
	/**
	 * 跳转到修改页面
	 **/
	public String edit(Model model, @PathVariable("id") Long id) {
		 Rt<BillUser> info = apiBillUser.info(id);
		model.addAttribute("model", info.getData());
		return "billuser/edit";
	}
	/**
	 * 信息
	 */
	@ResponseBody
	public Rt<BillUser> info(@PathVariable("id") Long id) {
		try {
			return apiBillUser.info(id);
		} catch (Exception e) {
			logger.error("查询失败", e);
			return Rt.error("查询失败");
		}
	}
	/**
	 * 保存
	 */
	@ResponseBody
	public Rt<String> save(@RequestBody BillUser billUser) {
		try {
			apiBillUser.save(billUser);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("保存失败", e);
			return Rt.error("保存失败");
		}
	}
	/**
	 * 修改
	 */
	@ResponseBody
	public Rt<String> update(@RequestBody BillUser billUser) {
		try {
			apiBillUser.update(billUser);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("修改失败", e);
			return Rt.error("修改失败");
		}
	}
	/**
	 * 启用
	 */
	@ResponseBody
	public Rt<String> enable(@RequestBody Long[] ids) {
		/*
		 * String stateValue=StateEnum.ENABLE.getCode();
		 * apiBillUser.updateDataFlag(ids,stateValue);
		 */
		return Rt.ok();
	}
	/**
	 * 禁用
	 */
	@ResponseBody
	public Rt<String> limit(@RequestBody Long[] ids) {
		/*
		 * String stateValue=StateEnum.LIMIT.getCode();
		 * apiBillUser.updateDataFlag(ids,stateValue);
		 */
		return Rt.ok();
	}
	/**
	 * 删除
	 */
	@ResponseBody
	public Rt<String> delete(@RequestBody Long[] ids) {
		try {
			apiBillUser.delete(ids);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("删除失败", e);
			return Rt.error("删除失败");
		}
	}

	@ResponseBody
	public Rt<String> logicDelete(@PathVariable("id") Long id) {
		try {
			apiBillUser.logicDelete(id);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("删除失败", e);
			return Rt.error("删除失败");
		}
	}
}
