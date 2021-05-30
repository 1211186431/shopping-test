package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.comment.UserComment;

public interface CommentService {
	/**
	 * 插入用户评论
	 * @param u
	 * @return
	 */
      public int insertUserCommentService(UserComment u);
      
      /**
       * 获取用户所有的评论
       * @param userId
       * @return
       */
      public ArrayList<UserComment> getCommentByUser(int userId);
      
      /**
       * 通过商品获取评论
       * @param goodsId
       * @return
       */
      public ArrayList<UserComment> getCommentByGoods(int goodsId);
      
      /**
       * 按照订单获取评论
       * @param goodsId
       * @param orderNum
       * @return
       */
      public UserComment getGoodsComment(int goodsId,String orderNum);
      
      /**
       * 更新用户评论
       * @param id
       * @param grade
       * @param content
       */
      public void upDateComment(int id,double grade,String content);
} 
