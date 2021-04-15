package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsShow;
import com.example.demo.service.GoodsService;

@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/goods/getAllGoods")
	public ArrayList<Goods> getAllGoods(){
		return this.goodsService.getAllGoods();
	}
	
	@GetMapping("/goods/getAllGoodsShow")
	public PageResult getAllGoodsShow(@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		return this.goodsService.getAllGoodsShow(pageNum,pageSize);
	}
	
	@GetMapping("/goods/getGoods")
	public Goods getGoods(@RequestParam("goodsId") int goodsId) {
		Goods g=this.goodsService.getGoodsById(goodsId);
		return g;
	}
	
	@PostMapping("/goods/insertGoods")
	public int insertGoods(@RequestBody Goods g) {
		return this.goodsService.insertGoods(g);
	}
	
	@PostMapping("/goods/upDateGoods")
	public void upDateGoods(@RequestBody Goods g) {
		this.goodsService.upDateGoods(g);
	}
	
	
}
