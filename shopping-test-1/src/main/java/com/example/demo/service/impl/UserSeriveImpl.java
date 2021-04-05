package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.mapper.InfoMapper;
import com.example.demo.dao.userMapper.UserMapper;
import com.example.demo.service.UserService;
@Service
public class UserSeriveImpl implements UserService {
	@Autowired
	private UserMapper UserMapper; 
	
	@Override
	public List<UserInfo> getAllUser() {
		// TODO Auto-generated method stub
		return this.UserMapper.getAllUser();
	}

	@Override
	public UserInfo getByName(String name) {
		// TODO Auto-generated method stub
		return this.UserMapper.getByName(name);
	}

	@Override
	public String insertOne(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if(this.UserMapper.getAllName().contains(userInfo.getName())) {
			return "用户名已存在";
		}
		else {
			BCryptPasswordEncoder encode= new BCryptPasswordEncoder(10);
			String password=encode.encode(userInfo.getPassword());
			userInfo.setPassword(password);
			this.UserMapper.insertOne(userInfo);
			return "创建成功";
		}
		
	}

}
