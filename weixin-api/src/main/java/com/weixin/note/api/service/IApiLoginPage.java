package com.weixin.note.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.jia.weixin.feign.loginpage.ILoginPage;
import com.weixin.enm.PubService;
@FeignClient(value = PubService.NOTE_SERVICE)
//@Headers({ "Accept: application/json", "Content-Type: application/json" })
public interface IApiLoginPage extends ILoginPage{

}
