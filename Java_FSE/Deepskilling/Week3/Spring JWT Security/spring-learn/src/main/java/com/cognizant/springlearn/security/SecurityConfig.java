package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	/**
	 * Defines two in-memory users: admin/pwd (role ADMIN) and user/pwd
	 * (role USER).
	 *
	 * IMPORTANT NOTE: hard coding user details is for learning purposes
	 * only. In a real application, credentials would be validated against
	 * a database (e.g. via Spring Data JPA).
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
				.and()
				.withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	/**
	 * Retains HTTP Basic authentication (used by /authenticate to obtain a
	 * JWT) and adds JwtAuthorizationFilter so that every other request must
	 * carry a valid "Authorization: Bearer <token>" header.
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().httpBasic().and()
				.authorizeRequests()
				// .antMatchers("/countries").hasRole("USER")
				.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
				.anyRequest().authenticated()
				.and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}

}
