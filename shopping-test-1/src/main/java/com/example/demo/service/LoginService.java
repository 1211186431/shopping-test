package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bean.AdminInfo;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.userMapper.AdminMapper;
import com.example.demo.dao.userMapper.UserMapper;
@Service
public class LoginService implements UserDetailsService {
    

	@Autowired
	private UserMapper userMapper; 
	
	@Autowired
	private AdminMapper adminMapper; 
	
	
	/**
	 * 尝试修改方法，但设置那边没有设置参数
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AdminInfo admin=adminMapper.getByName(username);
		if(admin==null) {
			UserInfo userInfo=userMapper.getByName(username);
			if(userInfo==null) {
				throw new UsernameNotFoundException("账号不存在");
			}
			else
				return userInfo;
		}else
			return admin;
	}

}
