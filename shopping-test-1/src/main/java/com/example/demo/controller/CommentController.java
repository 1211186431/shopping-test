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
/**
 * 用户评论接口
 * @author dy-xx
 *
 */
@RestController
public class CommentController {
	@Autowired
	CommentService cService;
    
	/**
	 * 获取用户的所有评论
	 * @param userId
	 * @return
	 */
	@GetMapping("/comment/getByUser")
	public ArrayList<UserComment> getCommentByUser(@RequestParam("userId") int userId) {
		return this.cService.getCommentByUser(userId);
	}
	
	/**
	 * 通过商品获取评论
	 * @param goodsId  商品Id
	 * @return
	 */
	@GetMapping("/comment/getByGoods")
	public ArrayList<UserComment> getCommentByGoods(@RequestParam("goodsId") int goodsId) {
		return this.cService.getCommentByGoods(goodsId);
	}
    
	/**
	 * 插入用户对商品的评论
	 * @param u  评论类
	 * @return
	 */
	@PostMapping("/comment/insert")
	public int insertUserComment(@RequestBody UserComment u) {
		return this.cService.insertUserCommentService(u);
	}
    
	/**
	 * 获取用户对订单中商品的评论
	 * @param goodsId  商品id
	 * @param orderNum 订单号
	 * @return
	 */
	@GetMapping("/comment/getByUserGoods")
	public UserComment getUserGoodsComment(@RequestParam("goodsId") int goodsId,
			@RequestParam("orderNum") String orderNum) {
		return this.cService.getGoodsComment(goodsId, orderNum);
	}
    
	/**
	 * 更新评论
	 * @param id   评论id
	 * @param grade  评分
	 * @param content 信息
	 */
	@PostMapping("/comment/update")
	public void upDateComment(@RequestParam("id") int id, @RequestParam("grade") double grade,
			@RequestParam("content") String content) {
		this.cService.upDateComment(id, grade, content);
	}
}
