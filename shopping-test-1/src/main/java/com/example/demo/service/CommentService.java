package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.comment.UserComment;

public interface CommentService {
      public int insertUserCommentService(UserComment u);
      
      public ArrayList<UserComment> getCommentByUser(int userId);
      
      public ArrayList<UserComment> getCommentByGoods(int goodsId);
      
      public ArrayList<UserComment> getCommentByAdmin(int adminId);
      
      public UserComment getGoodsComment(int goodsId,String orderNum);
      
      public void upDateComment(int id,double grade,String content);
} 
