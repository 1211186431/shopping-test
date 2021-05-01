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
		this.cMapper.insertUserComment(u);
		return u.getId();
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

	@Override
	public UserComment getGoodsComment(int goodsId, String orderNum) {
		// TODO Auto-generated method stub
		return this.cMapper.getGoodsComment(goodsId, orderNum);
	}

	@Override
	public void upDateComment(int id, double grade, String content) {
		// TODO Auto-generated method stub
		this.cMapper.upDateComment(id, grade, content);
	}

	@Override
	public ArrayList<UserComment> getCommentByGoods(int goodsId) {
		// TODO Auto-generated method stub
		return this.cMapper.getUserCommentByGoods(goodsId);
	}

}
