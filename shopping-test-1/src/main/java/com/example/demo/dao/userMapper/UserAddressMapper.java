package com.example.demo.dao.userMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.user.UserAddress;
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress>{
      @Insert("insert into useraddress(userId,address,phone) "
      		+ "values(#{userId},#{address},#{phone})")
      @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
      public void insertAddress(UserAddress u);
      
      @Select("select * from userAddress where userId=#{userId}")
      public ArrayList<UserAddress> getUserAddress(int userId);
}
