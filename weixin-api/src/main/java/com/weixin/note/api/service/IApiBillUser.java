package com.weixin.note.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.jia.weixin.feign.bill.IBillUser;
import com.weixin.enm.PubService;


/**
 * 用户表
 * 
 * @author 自动生成
 * @email 402376085@qq.com
 * @date 2018-08-27 17:05:38
 */
@FeignClient(value = PubService.NOTE_SERVICE)
public interface IApiBillUser extends IBillUser{
   
	
}
