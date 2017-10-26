package com.shaon.spring.webmvc.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ImportResource("classpath:/securityContext.xml")
public class SSOSecurityContext extends WebSecurityConfigurerAdapter {


}
