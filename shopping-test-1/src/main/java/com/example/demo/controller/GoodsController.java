package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsPic;
import com.example.demo.bean.goods.GoodsType;
import com.example.demo.service.GoodsService;



/**
 * 商品接口
 * @author dy-xx
 *
 */
@RestController

public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 获取所有的商品
	 * @return
	 */
	@GetMapping("/goods/getAllGoods")
	public ArrayList<Goods> getAllGoods(){
		return this.goodsService.getAllGoods();
	}
	
	/**
	 * 获取所有商品（分页）
	 * @param pageNum 页的号码
	 * @param pageSize 页的大小
	 * @return
	 */
	@GetMapping("/goods/getAllGoodsShow")
	public PageResult<?> getAllGoodsShow(@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		return this.goodsService.getAllGoodsShow(pageNum,pageSize);
	}
	
	@GetMapping("/goods/getGoodsShowByName")
	public PageResult<?> getGoodsShowByName(@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,@RequestParam("name") String name) {
		return this.goodsService.getGoodsShowByName(pageNum, pageSize, name);
	}
	
	
	/**
	 * 通过商品Id获取具体信息
	 * @param goodsId 商品Id
	 * @return
	 */
	@GetMapping("/goods/getGoods")
	public Goods getGoods(@RequestParam("goodsId") int goodsId){
		Goods g=this.goodsService.getGoodsById(goodsId);
		return g;
	}
	
	/**
	 * 添加商品
	 * @param g 商品类
	 * @return 商品id
	 */
	@PostMapping("/goods/insertGoods")
	public int insertGoods(@RequestBody Goods g) {
		
		return this.goodsService.insertGoods(g);
	}
	
	/**
	 * 更新商品
	 * @param g 商品类
	 */
	@PostMapping("/goods/upDateGoods")
	public void upDateGoods(@RequestBody Goods g) {
		this.goodsService.upDateGoods(g);
	}
	
	/**
	 * 获取商家的所有商品
	 * @param sellerId 商家id
	 * @return 商品列表
	 */
	@GetMapping("/goods/get/Byseller")
	public ArrayList<Goods> getGoodsBySeller(@RequestParam("sellerId") int sellerId){
		return this.goodsService.getGoodsBySeller(sellerId);
	}
	
	/**
	 * 获取所有的种类
	 * @return
	 */
	@GetMapping("/goods/getAllType")
	public ArrayList<GoodsType> getAllGoodsType(){
		return this.goodsService.getAllGoodsType();
	}
	
	/**
	 * 获取商品的所有照片
	 * @param goodsId 商品Id
	 * @return
	 */
	@GetMapping("/goods/getGoodsPic")
	public ArrayList<GoodsPic> getGoodsPic(@RequestParam("goodsId") int goodsId){
		return this.goodsService.getGoodsPic(goodsId);
	}
	
	/**
	 * 删除商品照片
	 * @param id 照片id
	 */
	@PostMapping("/goods/deletePic")
	public void deleteGoodsPic(@RequestParam("id") int id){
		 this.goodsService.deleteGoodsPic(id);
	}
	
	/**
	 * 上传图片，将图片添加到对应的商品中
	 * @param file 图片
	 * @param goodsId 商品id
	 * @return
	 * @throws IOException
	 */
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
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				m.put("error", "文件保存失败");
				return m;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.put("error", "文件保存失败");
				return m;
			}
			GoodsPic g=new GoodsPic();
			g.setGoodsId(goodsId);
			g.setPicture(f);
			this.goodsService.insertGoodsPic(g);
			if(i==0) {
				this.goodsService.upDateGoodsPic(f, goodsId);
			}
		}
		m.put("msg", goodsId+"");
		return m;
	}
}
