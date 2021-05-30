package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.user.UserAddress;
import com.example.demo.bean.user.UserInfo;

public interface UserService {
	public List<UserInfo> getAll();

	public List<UserInfo> getAllUser();
	
	public List<UserInfo> getAllAdmin();
    
    public UserInfo getByName(String name);
    
    public String insertOne(UserInfo userInfo); 
    
    public UserInfo getUserInfo(int userId);
    
    public void UpdateUserInfo(String email,String location,String phone,int sex,int userId);
    
    public ArrayList<UserAddress> getUserAddress(int id);
    
    public UserAddress getAddressById(int id);
    
    public int insertUserAddress(int userId,String phone,String address, String receiver);
    
    public void UpdateAddress(int userId,String phone,String address, String receiver,int id);
    
    public void DeleteAddress(int id);
    
}
