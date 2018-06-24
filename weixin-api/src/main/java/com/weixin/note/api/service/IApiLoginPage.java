package com.weixin.note.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import com.jia.weixin.feign.loginpage.ILoginPage;
@Component
@FeignClient(value = "NOTE-SERVICE")

public interface IApiLoginPage extends ILoginPage {
	
}
