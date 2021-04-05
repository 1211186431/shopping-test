package com.example.demo.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	LoginService loginSerive;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginSerive);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getAll").hasRole("admin").and().formLogin().loginPage("/index")
				.loginProcessingUrl("/login").usernameParameter("name").passwordParameter("password")
				.successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						// TODO Auto-generated method stub
						Object principal = authentication.getPrincipal();
						response.setContentType("application/json;charset=utf-8");
						PrintWriter out = response.getWriter();
						Map<String, Object> map = new HashMap<>();
						map.put("status", 200);
						map.put("msg", principal);
						ObjectMapper om = new ObjectMapper();
						out.write(om.writeValueAsString(map));
						out.flush();
						out.close();
					}

				}).failureHandler(new AuthenticationFailureHandler() {

					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						// TODO Auto-generated method stub
						response.setContentType("application/json;charset=utf-8");
						PrintWriter out = response.getWriter();
						response.setStatus(401);
						Map<String, Object> map = new HashMap<>();
						map.put("status", 401);
						if(exception instanceof LockedException) {
							map.put("msg", "账户被锁定，登录失败");
						}
						else if(exception instanceof BadCredentialsException) {
							map.put("msg", "账号或密码错误");
						}
						else if(exception instanceof DisabledException) {
							map.put("msg", "账户被禁用");
						}
						else if(exception instanceof AccountExpiredException) {
							map.put("msg", "账号已过期");
						}
						else if(exception instanceof CredentialsExpiredException) {
							map.put("msg", "密码已过期");
						}
						else {
							map.put("msg", "登录失败");
						}
						ObjectMapper om = new ObjectMapper();
						out.write(om.writeValueAsString(map));
						out.flush();
						out.close();
					}

				}).
				and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).
				addLogoutHandler(new LogoutHandler() {

					@Override
					public void logout(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) {
						// TODO Auto-generated method stub
						
					}
					
				}).logoutSuccessHandler(new LogoutSuccessHandler() {

					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						// TODO Auto-generated method stub
						response.setContentType("application/json;charset=utf-8");
						PrintWriter out = response.getWriter();
						Map<String, Object> map = new HashMap<>();
						map.put("msg", "退出成功");
						ObjectMapper om = new ObjectMapper();
						out.write(om.writeValueAsString(map));
						out.flush();
						out.close();
					}
					
				})
				.permitAll().and().csrf().disable();
	}
}
