package com.weixin.note.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import com.jia.weixin.feign.loginpage.ILoginPage;

import feign.Headers;
@Component
@FeignClient(value = "note-service")
@Headers({ "Accept: application/json", "Content-Type: application/json" })
public interface IApiLoginPage extends ILoginPage{

}
