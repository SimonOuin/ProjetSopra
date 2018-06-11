//package com.example.demo.configuration;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.example.demo.service.CustomUserDetailsService;
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	DataSource dataSource;
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//http.authorizeRequests().antMatchers("/hello", "/sec/welcome").permitAll().antMatchers("/sec/secure")
//		//		.authenticated().and().formLogin();
//		http.authorizeRequests().antMatchers("/rest/personne/**").authenticated().and().httpBasic();
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//	}
//	// authentification avec info directement en memoire
//	// @Autowired
//	// public void configAuthentication(AuthenticationManagerBuilder auth)
//	// throws Exception{
//	// auth.inMemoryAuthentication().withUser("simon").password("{noop}toto").roles("ADMIN");
//	// }
//
//	// authentifcation avec requete sql
//	// @Autowired
//	// public void configAuthentication(AuthenticationManagerBuilder auth)
//	// throws Exception {
//	// auth.jdbcAuthentication().dataSource(dataSource)
//	// .usersByUsernameQuery("select username,password,enable from users where
//	// username=?")
//	// .authoritiesByUsernameQuery("select username, role from user_roles where
//	// username=?");
//	// }
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println(getPasswordEncoder().encode("toto"));
//		auth.userDetailsService(customUserDetailsService).passwordEncoder(getPasswordEncoder());
//
//	}
//	
//	@Bean(name="passwordEncoder")
//	public PasswordEncoder getPasswordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
//}
