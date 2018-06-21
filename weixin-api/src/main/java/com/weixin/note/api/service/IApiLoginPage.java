package com.weixin.note.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.jia.weixin.feign.loginpage.ILoginPage;

@FeignClient(value = "note-service",path="/pageone")
public interface IApiLoginPage extends ILoginPage {

}
