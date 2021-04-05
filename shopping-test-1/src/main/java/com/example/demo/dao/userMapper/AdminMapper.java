package com.example.demo.dao.userMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.AdminInfo;

@Mapper
public interface AdminMapper extends BaseMapper<AdminInfo>{
	@Select("select * from admin where name = #{name}")
    public AdminInfo getByName(String name);
	
	@Select("select name from admin")
	public ArrayList<String> getAllName();
}
