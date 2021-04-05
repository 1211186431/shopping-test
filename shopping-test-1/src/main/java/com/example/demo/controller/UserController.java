package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserSeriveImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAll")
	public List<UserInfo> getAll(){
		return this.userService.getAllUser();
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("phone") String phone){
		UserInfo userInfo=new UserInfo(name,password,phone);
		
		
		return "注册成功:"+this.userService.insertOne(userInfo);
	}
	
}
