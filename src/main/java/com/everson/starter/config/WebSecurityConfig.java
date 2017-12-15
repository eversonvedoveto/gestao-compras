package com.everson.starter.config;




import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		//com JPA
		// http
		// .authorizeRequests()
		// .antMatchers("/resources/**", "/webjars/**").permitAll()
		// .anyRequest().authenticated()
		// .and()
		// .formLogin()
		// .loginPage("/login").permitAll()
		// .and()
		// .rememberMe();

		//EM MEMORIA
		builder
			.inMemoryAuthentication()
			.withUser("everson")
			.password("123987")
			.roles("USER");
		
		//COM JDBC
		
		

	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder builder) throws
	// Exception {
	// builder
	// .userDetailsService(ssUserDetailsService)
	// .passwordEncoder(new BCryptPasswordEncoder());
	//
	// }

}
