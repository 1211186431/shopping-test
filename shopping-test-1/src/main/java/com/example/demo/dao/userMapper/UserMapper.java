package com.example.demo.dao.userMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.user.UserInfo;


@Mapper
public interface UserMapper extends BaseMapper<UserInfo>{
	@Select("select * from user")
	public ArrayList<UserInfo> getAll();
	
	@Select("select * from user where role=\"ROLE_user\"")
	public ArrayList<UserInfo> getAllUser();
    
	@Select("select * from user where role=\"ROLE_admin\"")
	public ArrayList<UserInfo> getAllAdmin();
	
	@Select("select * from user where name = #{name}")
    public UserInfo getByName(String name);
	
    @Select("select id from user where role=\"ROLE_admin\" and state=1")  
    public ArrayList<Integer> getAdminId();
    
	@Select("select name from user")
	public ArrayList<String> getAllName();
    
    @Insert("insert into user(name,password,phone,role)"
    		+" values(#{name},#{password},#{phone},#{role})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public int insertOne(UserInfo userInfo); 
    
    @Select("select state from user where id=#{userId}")
    public int getUserState(int userId);
    
    @Update("update user set role=#{role} where id=#{userId}")
    public int updateUserRole(String role,int userId);
    
    @Update("update user set state=#{state} where id=#{userId}")
    public int updateUserState(int state,int userId);
    
    @Update("update user set money=#{b} where id=#{userId}")
    public int updateUserMoney(BigDecimal b,int userId);
    
    @Select("select * from user where id=#{userId}")
    public UserInfo getUserInfo(int userId);
    
    @Update("update user set email=#{email},location=#{location},phone=#{phone},sex=#{sex} where id=#{userId}")
    public void upDateUserInfo(String email,String location,String phone,int sex,int userId);
}
