package com.example.demo.service;

import java.util.List;


import com.example.demo.bean.UserInfo;

public interface UserService {

	public List<UserInfo> getAllUser();
    
    public UserInfo getByName(String name);
    
    public String insertOne(UserInfo userInfo); 
    
}
