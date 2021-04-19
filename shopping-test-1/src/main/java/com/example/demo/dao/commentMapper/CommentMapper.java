package com.example.demo.dao.commentMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.comment.UserComment;

@Mapper
public interface CommentMapper extends BaseMapper<UserComment>{
      @Select("select * from comment where user_id=#{user_id}")
      public ArrayList<UserComment> getUserCommentByUser(int user_id);
     
      @Select("select * from comment where seller_id=#{seller_id}")
      public ArrayList<UserComment> getUserCommentBySeller(int seller_id);
      
      @Insert("insert into comment(user_id,goods_id,content,createDate,state,grade,orderNum) "
      		+ "values(#{user_id},#{goods_id},#{content},#{createDate},#{state},#{grade},#{orderNum})")
      @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
      public int insertUserComment(UserComment u);
      
      @Select("select * from comment where goods_id=#{goodsId} and orderNum=#{orderNum}")
      public UserComment getGoodsComment(int goodsId,String orderNum);
      
      @Update("update comment set grade=#{grade},content=#{content} where id=#{id}")
      public void upDateComment(int id,double grade,String content);
}
