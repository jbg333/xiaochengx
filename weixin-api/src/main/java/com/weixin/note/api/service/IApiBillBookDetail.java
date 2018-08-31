package com.weixin.note.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.jia.weixin.feign.bill.IBillBookDetail;
import com.weixin.enm.PubService;

/**
 * 账单明细表
 * 
 * @author 自动生成
 * @email 402376085@qq.com
 * @date 2018-08-27 17:05:38
 */
@FeignClient(value = PubService.NOTE_SERVICE)
public interface IApiBillBookDetail extends IBillBookDetail{
	
}
