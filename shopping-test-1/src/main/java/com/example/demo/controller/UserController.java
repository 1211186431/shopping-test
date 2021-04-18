package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.user.UserAddress;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserSeriveImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/getAll")
	public List<UserInfo> getAll(){
		return this.userService.getAllUser();
	}
	
	@PostMapping("/user/register")
	public Map<String,String> register(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("phone") String phone){
		UserInfo userInfo=new UserInfo(name,password,phone,"ROLE_user");
		
		Map<String,String> map=new HashMap<>();
		String s=this.userService.insertOne(userInfo);
		map.put("msg", s);
		if(s.equals("创建成功")) {
			map.put("state","1");
		}
		else {
		   map.put("state", "0");	
		}
		return map;
	}
	
	@GetMapping("/user/getUserInfo")
	public UserInfo getUserInfo(@RequestParam("userId") int userId) {
		return this.userService.getUserInfo(userId);
	}
	
	@PostMapping("/user/UpDateInfo")
	public String UpdateUserInfo(@RequestParam("email")String email,
			@RequestParam("location")String location,@RequestParam("phone")String phone,
			@RequestParam("sex")int sex,@RequestParam("userId")int userId) {
		this.userService.UpdateUserInfo(email, location, phone, sex, userId);
		return "1";
	}
	
	@GetMapping("/user/getUserAddress")
	public ArrayList<UserAddress> getUserAddress(@RequestParam("userId") int userId) {
		return this.userService.getUserAddress(userId);
	}
	
	@PostMapping("/user/insertAddress")
	public int insertAddress(@RequestParam("address")String address,
			@RequestParam("phone")String phone,@RequestParam("userId")int userId) {
		return this.userService.insertUserAddress(userId, phone, address);
	}
	
}
