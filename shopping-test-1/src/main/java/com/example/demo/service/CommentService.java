package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.comment.UserComment;

public interface CommentService {
      public int insertUserCommentService(UserComment u);
      
      public ArrayList<UserComment> getCommentByUser(int userId);
      
      public ArrayList<UserComment> getCommentByAdmin(int adminId);
} 
