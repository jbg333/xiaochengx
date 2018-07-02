/*package com.jia.code.generator;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import com.gh.sso.config.SSOConfig;
//import com.gh.sso.starter.SSOProperties;

import freemarker.template.utility.XmlEscape;

@Configuration
//@EnableConfigurationProperties(SSOProperties.class)
public class WebMvcConfig extends WebMvcConfigurationSupport {// org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter{


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
				//.addResourceLocations("classpath:/templates/");

	}

	@Autowired
	private SSOProperties properties;

	*//**
	 * 注入初始化
	 *//*
	@Bean
	public SSOConfig getInstance() {
		return SSOConfig.init(properties.getConfig());
	}
	
	
	
	
	@Autowired
	private FreeMarkerViewResolver freeMarkerViewResolver;

	@Autowired
	private freemarker.template.Configuration freemarkerConfiguration;

	@Bean
	@ConditionalOnProperty(name = "spring.freemarker.enabled", matchIfMissing = true)
	public FreeMarkerViewResolver getFreemarkViewResolver() {
		// freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");

		freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
		return freeMarkerViewResolver;
	}

	@PostConstruct
	@ConditionalOnProperty(name = "spring.freemarker.enabled", matchIfMissing = true)
	public void setSharedVariable() {
		freemarkerConfiguration.setSharedVariable("xml_escape", new XmlEscape());
	}

	 

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		
		 * using the StringHttpMessageConverter to handle with simple String
		 * message.
		 

		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(stringConverter);
		
		 * using the FastJsonHttpMessageConverter to handle these below. 1.
		 * text/html;charset=UTF-8 a page(htm/html/jsp etc.) 2.
		 * application/json;charset=utf-8 json data type response 3.
		 * text/plain;charset=UTF-8 a text or string etc. 4.
		 * application/x-www-form-urlencoded;charset=utf-8 standard encoding
		 * type. convert form data to a key-value. ...
		 
		FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(Charset.forName("UTF-8"));
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		fastJsonConverter.setFastJsonConfig(fastJsonConfig);
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		MediaType text_plain = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		MediaType text_html = new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8"));
		MediaType x_www_form_urlencoded_utf8 = new MediaType(MediaType.APPLICATION_FORM_URLENCODED,
				Charset.forName("UTF-8"));
		supportedMediaTypes.add(text_html);
		supportedMediaTypes.add(text_plain);
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(x_www_form_urlencoded_utf8);

		fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(fastJsonConverter);
		super.configureMessageConverters(converters);

	}

}
*/