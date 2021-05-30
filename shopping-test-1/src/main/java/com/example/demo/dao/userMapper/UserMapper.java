package com.example.demo.dao.userMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.user.UserInfo;


@Mapper
public interface UserMapper extends BaseMapper<UserInfo>{
	/**
	 * 获取所有的用户和管理员
	 * @return
	 */
	@Select("select * from user")
	public ArrayList<UserInfo> getAll();
	
	/**
	 * 获取全部的用户
	 * @return
	 */
	@Select("select * from user where role=\"ROLE_user\"")
	public ArrayList<UserInfo> getAllUser();
    
	/**
	 * 获取全部管理员
	 * @return
	 */
	@Select("select * from user where role=\"ROLE_admin\"")
	public ArrayList<UserInfo> getAllAdmin();
	
	/**
	 * 通过用户名获取用户信息
	 * @param name
	 * @return
	 */
	@Select("select * from user where name = #{name}")
    public UserInfo getByName(String name);
	
	/**
	 * 获取可用的管理员
	 * @return
	 */
    @Select("select id from user where role=\"ROLE_admin\" and state=1")  
    public ArrayList<Integer> getAdminId();
    
    /**
     * 获取所有的用户名
     * @return
     */
	@Select("select name from user")
	public ArrayList<String> getAllName();
    
	/**
	 * 创建新用户
	 * @param userInfo
	 * @return
	 */
    @Insert("insert into user(name,password,phone,role)"
    		+" values(#{name},#{password},#{phone},#{role})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public int insertOne(UserInfo userInfo); 
    
    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    @Select("select state from user where id=#{userId}")
    public int getUserState(int userId);
    
    /**
     * 设置用户权限
     * @param role
     * @param userId
     * @return
     */
    @Update("update user set role=#{role} where id=#{userId}")
    public int updateUserRole(String role,int userId);
    
    /**
     * 设置用户状态
     * @param state
     * @param userId
     * @return
     */
    @Update("update user set state=#{state} where id=#{userId}")
    public int updateUserState(int state,int userId);
    
    /**
     * 设置用户金额
     * @param b
     * @param userId
     * @return
     */
    @Update("update user set money=#{b} where id=#{userId}")
    public int updateUserMoney(BigDecimal b,int userId);
    
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{userId}")
    public UserInfo getUserInfo(int userId);
    
    /**
     * 更新用户信息
     * @param email
     * @param location
     * @param phone
     * @param sex
     * @param userId
     */
    @Update("update user set email=#{email},location=#{location},phone=#{phone},sex=#{sex} where id=#{userId}")
    public void upDateUserInfo(String email,String location,String phone,int sex,int userId);
}
