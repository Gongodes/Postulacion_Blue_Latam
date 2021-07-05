/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gonzalo.agenda.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author gonzalo
 */
@Configuration
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter{
  	
	@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        //configureothers if u wants.
        .csrf().disable();
}
}
    

