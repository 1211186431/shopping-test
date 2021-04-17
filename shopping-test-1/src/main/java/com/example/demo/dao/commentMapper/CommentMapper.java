package com.example.demo.dao.commentMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.comment.UserComment;

@Mapper
public interface CommentMapper extends BaseMapper<UserComment>{
      @Select("select * from comment where user_id=#{user_id}")
      public ArrayList<UserComment> getUserCommentByUser(int user_id);
     
      @Select("select * from comment where seller_id=#{seller_id}")
      public ArrayList<UserComment> getUserCommentBySeller(int seller_id);
      
      @Insert("insert into comment(user_id,seller_id,content,createDate,state,grade) "
      		+ "values(#{user_id},#{seller_id},#{content},#{createDate},#{state},#{grade})")
      @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
      public int insertUserComment(UserComment u);
}
