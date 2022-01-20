package com.webapp.crm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		UserBuilder users = User.withDefaultPasswordEncoder();

//		auth.inMemoryAuthentication().
//		withUser(users.username("Admin").password("test123").roles("ADMINISTRATOR")).
//		withUser(users.username("Guest").password("guest").roles("GUEST"));
		
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();

		http.authorizeRequests()
		//anyRequest().authenticated(). (for login without role based access)
		.antMatchers("/").permitAll()
		.antMatchers("/customer/list").hasAnyRole("GUEST","ADMINISTRATOR")
		.antMatchers("/customer/**").hasRole("ADMINISTRATOR")
		.and().formLogin().loginPage("/login").loginProcessingUrl("/authenticateUser").permitAll()
				.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");		
	}

}
