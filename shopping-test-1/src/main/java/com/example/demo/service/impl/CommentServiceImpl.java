package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.comment.UserComment;
import com.example.demo.dao.commentMapper.CommentMapper;
import com.example.demo.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper cMapper;
	
	@Override
	public int insertUserCommentService(UserComment u) {
		// TODO Auto-generated method stub
		return this.cMapper.insertUserComment(u);
	}

	@Override
	public ArrayList<UserComment> getCommentByUser(int userId) {
		// TODO Auto-generated method stub
		return this.cMapper.getUserCommentByUser(userId);
	}

	@Override
	public ArrayList<UserComment> getCommentByAdmin(int adminId) {
		// TODO Auto-generated method stub
		return this.getCommentByAdmin(adminId);
	}

}
