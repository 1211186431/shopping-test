package com.example.demo.dao.userMapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.ShoppingInfo;
import com.example.demo.bean.UserInfo;


@Mapper
public interface UserMapper extends BaseMapper<UserInfo>{
	@Select("select * from user")
	public List<UserInfo> getAllUser();
    
	@Select("select * from user where name = #{name}")
    public UserInfo getByName(String name);
	

	@Select("select name from user")
	public ArrayList<String> getAllName();
    
    @Insert("insert into user(name,password,phone)"
    		+" values(#{name},#{password},#{phone})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public int insertOne(UserInfo userInfo); 
}
