package com.weixin.note.serv.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.weixin.entity.BillUser;
import com.weixin.note.serv.service.BillUserService;
import com.weixin.util.Query;
import com.weixin.util.Rt;
import com.weixin.util.RtPageUtils;

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
@RequestMapping("billuser")
public class BillUserController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BillUserService billUserService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @RequiresPermissions("billuser:list")
    public String list() {
        return "billuser/list";
    }
    
	/**
	 * 列表数据
	 */
	@ApiOperation("列表查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "params", value = "查询参数", required = true, dataType = "Map", paramType = "query")
	})
	@ApiResponses(value = { 
			@ApiResponse(response=BillUser.class,code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回")
	})	
    @ResponseBody
	@RequestMapping(value = "/listData", method = {RequestMethod.POST})
	@RequiresPermissions("billuser:list")
	public Rt<BillUser> listData(@RequestParam Map<String, Object> params){
		//查询列表数据
		try {
			Query query = new Query(params);
	    	PageInfo<BillUser> billUserResult = billUserService.queryPageList(query);
	    	RtPageUtils<BillUser> pageUtil = new RtPageUtils<>(billUserResult.getList(), billUserResult.getTotal(), query.getLimit(), query.getPage());
	    	return Rt.ok(pageUtil);
	   } catch (Exception e) {
			logger.error("查询列表失败",e);
			return Rt.error("查询列表失败");
		}
	}
	
	
	 /**
     * 
     * listDataNoPage:(不分页查询). 
     * @author jbg  
     * @param params
     * @return  
     * @since JDK 1.8
     */
    @ApiOperation("列表查询不分页")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "params", value = "查询参数", required = true, dataType = "Map", paramType = "query")
	})
	@ApiResponses(value = { 
			@ApiResponse(response=BillUser.class,responseContainer="List",code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回")
	})	
    @ResponseBody
  	@RequestMapping(value = "/listDataNoPage", method = {RequestMethod.POST})
  	public Rt<List<BillUser>> listDataNoPage(@RequestParam Map<String, Object> params){
  		//查询列表数据
    	List<BillUser> list = billUserService.getList(params);
  		return Rt.ok(list);
  	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    @RequiresPermissions("billuser:save")
    public String add(){
        return "billuser/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    @RequiresPermissions("billuser:update")
    public String edit(Model model, @PathVariable("id") Long id){
		BillUser billUser = billUserService.get(id);
        model.addAttribute("model",billUser);
        return "billuser/edit";
    }

	/**
	 * 信息
	 */
	@ApiOperation("根据id查询数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "数据id", required = true, dataType = "Long", paramType = "path")
	})
	@ApiResponses(value = { 
			@ApiResponse(response=BillUser.class,code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回")
	})	
    @ResponseBody
    @RequestMapping(value = "/info/{id}", method = {RequestMethod.GET})
    @RequiresPermissions("billuser:info")
    public Rt<BillUser> info(@PathVariable("id") Long id){
	    try {
	       
	        BillUser billUser = billUserService.get(id);
	        return Rt.ok(billUser);
		} catch (Exception e) {
				logger.error("查询失败",e);
				return Rt.error("查询失败");
		}
    
    }

    /**
	 * 保存
	 */
	@ApiOperation("保存数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "billUser", value = "数据实体", required = true, dataType = "BillUser", paramType = "query")
	})
	@ApiResponses(value = { 
			@ApiResponse(response=String.class,code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回")
	})	
    @ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	@RequiresPermissions("billuser:save")
	public Rt<String> save(@RequestBody BillUser billUser){
		 try {
			billUserService.save(billUser);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("保存失败",e);
			return Rt.error("保存失败");
		}
	}
	
	/**
	 * 修改
	 */
	@ApiOperation("修改数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "billUser", value = "数据实体", required = true, dataType = "BillUser", paramType = "query")
	})
	@ApiResponses(value = { 
			@ApiResponse(response=String.class,code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回")
	})	
    @ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	@RequiresPermissions("billuser:update")
	public Rt<String> update(@RequestBody BillUser billUser){
		 try {
			billUserService.update(billUser);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("修改失败",e);
			return Rt.error("修改失败");
		}
	}

    /**
     * 启用
     */
    @ResponseBody
    @RequestMapping(value = "/enable", method = {RequestMethod.POST})
    @RequiresPermissions("billuser:update")
    public Rt<String> enable(@RequestBody Long[] ids){
        /*String stateValue=StateEnum.ENABLE.getCode();
		billUserService.updateDataFlag(ids,stateValue);*/
        return Rt.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @RequestMapping(value = "/limit", method = {RequestMethod.POST})
    @RequiresPermissions("billuser:update")
    public Rt<String> limit(@RequestBody Long[] ids){
      /*  String stateValue=StateEnum.LIMIT.getCode();
		billUserService.updateDataFlag(ids,stateValue);*/
        return Rt.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	@RequiresPermissions("billuser:delete")
	public Rt<String> delete(@RequestBody Long[] ids){
		 try {
			billUserService.deleteBatch(ids);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("删除失败",e);
			return Rt.error("删除失败");
		}
	}
	
	
	/**
	 * 逻辑删除
	 */
	@ApiOperation("逻辑删除数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Long", value = "数据实体", required = true, dataType = "Long", paramType = "path")
	})
	@ApiResponses(value = { 
			@ApiResponse(response=String.class,code = 200, message = "操作成功"),
			@ApiResponse(code = 500, message = "内部错误，信息由msg字段返回")
	})	
    @ResponseBody
	@RequestMapping(value = "/logicDelete/{id}", method = {RequestMethod.POST})
	public Rt<String> logicDelete(@PathVariable("id") Long id){
		 try {
			billUserService.logicDelete(id);
			return Rt.ok();
		} catch (Exception e) {
			logger.error("删除失败",e);
			return Rt.error("删除失败");
		}
	}
	
}
