package com.intake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService intakeUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Bcrypt encrypted rounds varies from 4- 31
		auth.userDetailsService(intakeUserDetailsService).passwordEncoder(new BCryptPasswordEncoder(5));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		// don't authenticate '/authenticate' request
		.authorizeRequests().antMatchers("/authenticate").permitAll()
		// all other requests need to be authenticated
		.anyRequest().authenticated()
		.and()
		//stateless session- session won't be used to store user's state
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
	

}
