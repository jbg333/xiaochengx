package com.jia.weixin.feign.bill;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.entity.BillUser;
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
@Controller
@RequestMapping("billuser")
public interface IBillUser {
    /**
     * 跳转到列表页
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String list();
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping(value = "/listData", method = {RequestMethod.POST})
	
	public Rt<BillUser> listData(@RequestParam Map<String, Object> params);
	
	
	 /**
     * 
     * listDataNoPage:(不分页查询). 
     * @author jbg  
     * @param params
     * @return  
     * @since JDK 1.8
     */
    @ResponseBody
  	@RequestMapping(value = "/listDataNoPage", method = {RequestMethod.POST})
  	public Rt<List<BillUser>> listDataNoPage(@RequestParam Map<String, Object> params);

    /**
     * 跳转到新增页面
     **/
    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    
    public String add();

    /**
     *   跳转到修改页面
     **/
    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    
    public String edit(Model model, @PathVariable("id") Long id);

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping(value = "/info/{id}", method = {RequestMethod.GET})
    
    public Rt<BillUser> info(@PathVariable("id") Long id);

    /**
	 * 保存
	 */
    @ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	
	public Rt<String> save(@RequestBody BillUser billUser);
	
	/**
	 * 修改
	 */
    @ResponseBody
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	
	public Rt<String> update(@RequestBody BillUser billUser);

    /**
     * 启用
     */
    @ResponseBody
    @RequestMapping(value = "/enable", method = {RequestMethod.POST})
    
    public Rt<String> enable(@RequestBody Long[] ids);
    /**
     * 禁用
     */
    @ResponseBody
    @RequestMapping(value = "/limit", method = {RequestMethod.POST})
    
    public Rt<String> limit(@RequestBody Long[] ids);
	/**
	 * 删除
	 */
    @ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	
	public Rt<String> delete(@RequestBody Long[] ids);
	
	
	/**
	 * 逻辑删除
	 */
    @ResponseBody
	@RequestMapping(value = "/logicDelete/{id}", method = {RequestMethod.POST})
	public Rt<String> logicDelete(@PathVariable("id") Long id);
	
}
