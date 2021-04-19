package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.comment.UserComment;
import com.example.demo.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	CommentService cService;

	@GetMapping("/comment/getByUser")
	public ArrayList<UserComment> getCommentByUser(@RequestParam("userId") int userId) {
		return this.cService.getCommentByUser(userId);
	}

	@GetMapping("/comment/getByAdmin")
	public ArrayList<UserComment> getCommentByAdmin(@RequestParam("adminId") int adminId) {
		return this.cService.getCommentByAdmin(adminId);
	}

	@PostMapping("/comment/insert")
	public int insertUserComment(@RequestBody UserComment u) {
		return this.cService.insertUserCommentService(u);
	}

	@GetMapping("/comment/getByUserGoods")
	public UserComment getUserGoodsComment(@RequestParam("goodsId") int goodsId,
			@RequestParam("orderNum") String orderNum) {
		return this.cService.getGoodsComment(goodsId, orderNum);
	}

	@PostMapping("/comment/update")
	public void upDateComment(@RequestParam("id") int id, @RequestParam("grade") double grade,
			@RequestParam("content") String content) {
		this.cService.upDateComment(id, grade, content);
	}
}
