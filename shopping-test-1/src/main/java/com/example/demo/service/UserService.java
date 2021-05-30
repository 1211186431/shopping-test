package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.user.UserAddress;
import com.example.demo.bean.user.UserInfo;

public interface UserService {
	/**
	 * 获取全部用户和管理员
	 * @return
	 */
	public List<UserInfo> getAll();

	/**
	 * 获取全部用户
	 * @return
	 */
	public List<UserInfo> getAllUser();
	
	/**
	 * 获取所有管理员
	 * @return
	 */
	public List<UserInfo> getAllAdmin();
    
	/**
	 * 通过用户名获取用户信息
	 * @param name
	 * @return
	 */
    public UserInfo getByName(String name);
    
    /**
     * 插入用户信息
     * @param userInfo
     * @return
     */
    public String insertOne(UserInfo userInfo); 
    
    /**
     * 通过id获取用户信息
     * @param userId
     * @return
     */
    public UserInfo getUserInfo(int userId);
    
    /**
     * 更新用户信息
     * @param email
     * @param location
     * @param phone
     * @param sex
     * @param userId
     */
    public void UpdateUserInfo(String email,String location,String phone,int sex,int userId);
    
    /**
     * 获取用户全部的收货地址
     * @param id
     * @return
     */
    public ArrayList<UserAddress> getUserAddress(int id);
    
    /**
     * 获取指定的收货地址
     * @param id
     * @return
     */
    public UserAddress getAddressById(int id);
    
    /**
     * 插入用户地址
     * @param userId
     * @param phone
     * @param address
     * @param receiver
     * @return
     */
    public int insertUserAddress(int userId,String phone,String address, String receiver);
    
    /**
     * 更新用户地址
     * @param userId
     * @param phone
     * @param address
     * @param receiver
     * @param id
     */
    public void UpdateAddress(int userId,String phone,String address, String receiver,int id);
    
    /**
     * 删除用户地址
     * @param id
     */
    public void DeleteAddress(int id);
    
}
