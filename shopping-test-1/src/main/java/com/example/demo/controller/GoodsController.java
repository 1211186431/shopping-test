package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsPic;
import com.example.demo.bean.goods.GoodsShow;
import com.example.demo.bean.goods.GoodsType;
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
	
	@GetMapping("/goods/get/Byseller")
	public ArrayList<Goods> getGoodsBySeller(@RequestParam("sellerId") int sellerId){
		return this.goodsService.getGoodsBySeller(sellerId);
	}
	
	@GetMapping("/goods/getAllType")
	public ArrayList<GoodsType> getAllGoodsType(){
		return this.goodsService.getAllGoodsType();
	}
	
	@GetMapping("/goods/getGoodsPic")
	public ArrayList<GoodsPic> getGoodsPic(@RequestParam("goodsId") int goodsId){
		return this.goodsService.getGoodsPic(goodsId);
	}
	
	@PostMapping("/goods/deletePic")
	public void deleteGoodsPic(@RequestParam("id") int id){
		 this.goodsService.deleteGoodsPic(id);
	}
	
	@PostMapping("/goods/uploadPic")
	public Map<String, String> insertAudit(MultipartFile file[],@RequestParam("goodsId") int goodsId)  throws IOException{
		Map<String,String> m=new HashMap<>();
		for(int i=0;i<file.length;i++) {
			String f="/goodsPic/"+goodsId+"_"+i+"_"+file[i].getOriginalFilename();
			String fileName = "src/main/resources/static/goodsPic/"+goodsId+"_"+i+"_"+file[i].getOriginalFilename();
		    FileOutputStream fos;
			try {
				fos = new FileOutputStream(new File(fileName));
			    IOUtils.copy(file[i].getInputStream(),fos);
				fos.close();
				GoodsPic g=new GoodsPic();
				g.setGoodsId(goodsId);
				g.setPicture(f);
				this.goodsService.insertGoodsPic(g);
				if(i==0) {
					this.goodsService.upDateGoodsPic(f, goodsId);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		m.put("msg", goodsId+"");
		return m;
	}
}
