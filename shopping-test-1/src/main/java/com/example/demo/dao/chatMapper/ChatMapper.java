package com.example.demo.dao.chatMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.chat.Chat;

@Mapper
public interface ChatMapper extends BaseMapper<Chat>{
	/**
	 * 插入聊天
	 * @param c
	 * @return
	 */
   @Insert("insert into userchat(toUser,fromUser,userContent,crateDate)"
   		+ " value(#{toUser},#{fromUser},#{userContent},#{crateDate})")
   public int insertChat(Chat c);
   
   /**
    * 按照两个用户名，查找聊天记录
    * @param fromUser
    * @param toUser
    * @return
    */
   @Select("select * from userchat where (fromUser=#{fromUser} and toUser=#{toUser})"
   		+ " or (fromUser=#{toUser} and toUser=#{fromUser})")
   public ArrayList<Chat> getUserChat(String fromUser,String toUser);
}
