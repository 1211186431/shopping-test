package com.example.demo.dao.chatMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.chat.Chat;

@Mapper
public interface ChatMapper extends BaseMapper<Chat>{
   @Insert("insert into userchat(toUser,fromUser,userContent,crateDate)"
   		+ " value(#{toUser},#{fromUser},#{userContent},#{crateDate})")
   public int insertChat(Chat c);
   
   @Select("select * from userchat where (fromUser=#{fromUser} and toUser=#{toUser})"
   		+ " or (fromUser=#{toUser} and toUser=#{fromUser})")
   public ArrayList<Chat> getUserChat(String fromUser,String toUser);
}
