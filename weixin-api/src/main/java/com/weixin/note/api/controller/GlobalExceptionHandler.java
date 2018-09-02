package com.weixin.note.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.util.Rt;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*@ExceptionHandler(value=Exception.class)
	@ResponseBody
	private Map<String,Object>exceptionHandler(HttpServletRequest req,Exception e){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("success", false);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
		
	}*/
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	private Rt<String> exceptionHandler(HttpServletRequest req,Exception e){
		return Rt.error(e.getMessage());
		
	}
}
