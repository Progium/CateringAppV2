package com.progium.catering.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.progium.catering"})
@EnableAutoConfiguration

@EnableJpaRepositories("com.progium.catering.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "com.progium.catering.ejb")

public class ProgiumApplication{
	
    public static void main(String[] args) {
        SpringApplication.run(ProgiumApplication.class, args);
    }
    
	@Bean	
	public FilterRegistrationBean filterRegistrationBean() {
		
		List<String> urls = new ArrayList<String>();
		urls.add("/*");
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		PassthroughFilter passFilter = new PassthroughFilter();
		registrationBean.setFilter(passFilter);
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}
	
	@Bean	
	public FilterRegistrationBean filterRegistrationBean2() {
		
		List<String> urls = new ArrayList<String>();
		urls.add("/rest/protected/*");
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		WSFilter wsFilter = new WSFilter();
		registrationBean.setFilter(wsFilter);
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}
}
