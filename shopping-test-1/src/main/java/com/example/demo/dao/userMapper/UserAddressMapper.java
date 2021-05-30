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
/**
 * 用户住址
 * @author dy-xx
 *
 */
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress>{
	/**
	 * 插入用户住址
	 * @param u
	 */
      @Insert("insert into useraddress(userId,address,phone,receiver) "
      		+ "values(#{userId},#{address},#{phone},#{receiver})")
      @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
      public void insertAddress(UserAddress u);
      
      /**
       * 获取所有的住址
       * @param userId
       * @return
       */
      @Select("select * from userAddress where userId=#{userId}")
      public ArrayList<UserAddress> getUserAddress(int userId);
      
      /**
       * 按照id获取指定住址
       * @param id
       * @return
       */
      @Select("select * from userAddress where id=#{id}")
      public UserAddress getAddressById(int id);
      
      /**
       * 更新住址信息
       * @param userId
       * @param phone
       * @param address
       * @param receiver
       * @param id
       */
      @Update("update userAddress set userId=#{userId},address=#{address},phone=#{phone},receiver=#{receiver} where id=#{id}")
      public void UpdateAddress(int userId,String phone,String address, String receiver,int id);
      
      /**
       * 删除住址
       * @param id
       */
      @Delete("delete from userAddress where id=#{id}")
      public void DeleteAddress(int id);
}
