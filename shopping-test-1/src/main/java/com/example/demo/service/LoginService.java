package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bean.user.UserInfo;
import com.example.demo.dao.userMapper.UserMapper;
/**
 * 登录
 * @author dy-xx
 *
 */
@Service
public class LoginService implements UserDetailsService {
    

	@Autowired
	private UserMapper userMapper; 
 	
	/**
	 * 尝试修改方法，但设置那边没有设置参数
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			UserInfo userInfo=userMapper.getByName(username);
			if(userInfo==null) {
				throw new UsernameNotFoundException("账号不存在");
			}
			else
				return userInfo;
	}

}
