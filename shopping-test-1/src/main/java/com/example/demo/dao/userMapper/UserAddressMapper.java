package com.example.demo.dao.userMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.user.UserAddress;
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress>{
      @Insert("insert into useraddress(userId,address,phone,receiver) "
      		+ "values(#{userId},#{address},#{phone},#{receiver})")
      @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
      public void insertAddress(UserAddress u);
      
      @Select("select * from userAddress where userId=#{userId}")
      public ArrayList<UserAddress> getUserAddress(int userId);
      
      @Select("select * from userAddress where id=#{id}")
      public UserAddress getAddressById(int id);
      
      @Update("update userAddress set userId=#{userId},address=#{address},phone=#{phone},receiver=#{receiver} where id=#{id}")
      public void UpdateAddress(int userId,String phone,String address, String receiver,int id);
      
      @Delete("delete from userAddress where id=#{id}")
      public void DeleteAddress(int id);
}
