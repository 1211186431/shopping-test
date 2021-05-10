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
	/**
	 * 获取所有的用户评论（管理员用）
	 * @return
	 */
	  @Select("select * from comment")
      public ArrayList<UserComment> getAllUserComment();
	
	  /**
	   * 获取指定用户的所有评论（用户）
	   * @param user_id
	   * @return
	   */
      @Select("select * from comment where user_id=#{user_id}")
      public ArrayList<UserComment> getUserCommentByUser(int user_id);
     
      /**
       * 获取指定商品的所有评论（商家）
       * @param goods_id
       * @return
       */
      @Select("select * from comment where goods_id=#{goods_id}")
      public ArrayList<UserComment> getUserCommentByGoods(int goods_id);
      
      /**
       * 插入用户评论
       * @param u
       * @return
       */
      @Insert("insert into comment(user_id,goods_id,content,createDate,state,grade,orderNum) "
      		+ "values(#{user_id},#{goods_id},#{content},#{createDate},#{state},#{grade},#{orderNum})")
      @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
      public int insertUserComment(UserComment u);
      
      /**
       * 获取订单中指定商品评论
       * @param goodsId
       * @param orderNum
       * @return
       */
      @Select("select * from comment where goods_id=#{goodsId} and orderNum=#{orderNum}")
      public UserComment getGoodsComment(int goodsId,String orderNum);
      
      /**
       * 更新评论
       * @param id
       * @param grade
       * @param content
       */
      @Update("update comment set grade=#{grade},content=#{content} where id=#{id}")
      public void upDateComment(int id,double grade,String content);
      
      /**
       * 设置评论状态（管理员）
       * @param state
       * @param id
       */
      @Update("update comment set state=#{state} where id=#{id}")
      public void upDateCommentState(int state,int id);
}
