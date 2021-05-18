package com.example.demo.service.impl;

import java.io.File;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsPic;
import com.example.demo.bean.goods.GoodsShow;
import com.example.demo.bean.goods.GoodsType;
import com.example.demo.dao.goodsMapper.GoodsMapper;
import com.example.demo.dao.picMapper.GoodsPicMapper;
import com.example.demo.helper.PageUtils;
import com.example.demo.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired 
    private GoodsMapper gMapper;
    
    @Autowired 
    private GoodsPicMapper gPMapper;
    
	@Override
	public ArrayList<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return this.gMapper.getAllGoods();
	}

	@Override
	public PageResult<?> getAllGoodsShow(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<GoodsShow> pageInfos=new PageInfo<>(this.gMapper.getGoodsShow());
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		Goods g=this.gMapper.getGoodsById(goodsId);
		g.setGoodstype(this.gMapper.getGoodsType(goodsId));
		return g;
	}

	@Override
	public int insertGoods(Goods g) {
		// TODO Auto-generated method stub
		this.gMapper.insertGoods(g);
		int goodsId=g.getId();
		for(int i=0;i<g.getGoodstype().size();i++) {
			this.gMapper.insertGoodsType(g.getGoodstype().get(i).getType_id(),goodsId);
		}
		return g.getId();
	}

	@Override
	public void upDateGoods(Goods g) {
		// TODO Auto-generated method stub
		this.gMapper.upDateGoods(g);
		this.gMapper.deleteGoodsType(g.getId());
		int goodsId=g.getId();
		for(int i=0;i<g.getGoodstype().size();i++) {
			this.gMapper.insertGoodsType(g.getGoodstype().get(i).getType_id(),goodsId);
		}
	}

	@Override
	public ArrayList<Goods> getGoodsBySeller(int sellerId) {
		// TODO Auto-generated method stub
		return this.gMapper.getGoodsBySeller(sellerId);
	}

	@Override
	public ArrayList<GoodsType> getAllGoodsType() {
		// TODO Auto-generated method stub
		return this.gMapper.getAllGoodsType();
	}

	@Override
	public int insertGoodsPic(GoodsPic g) {
		// TODO Auto-generated method stub
		return this.gPMapper.insertPic(g);
	}

	@Override
	public void upDateGoodsPic(String pic,int goodsId) {
		// TODO Auto-generated method stub
		this.gMapper.upDateGoodsPic(pic, goodsId);
	}

	@Override
	public ArrayList<GoodsPic> getGoodsPic(int goodsId) {
		// TODO Auto-generated method stub
		return this.gPMapper.getGoodsPic(goodsId);
	}

	@Override
	public void deleteGoodsPic(int id) {
		// TODO Auto-generated method stub
		String filePath=this.gPMapper.getPicPath(id);
		String path="src/main/resources/static"+filePath;
		File pic=new File(path);
		if(pic.exists()) {
			pic.delete();
			this.gPMapper.deleteGoodsPic(id);
		}
	}

	
	@Override
	public PageResult<?> getGoodsShow(int pageNum, int pageSize,int type,String name,String priceSort
    		,String salesSort,String gradeSort) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<GoodsShow> pageInfos=new PageInfo<>(this.gMapper.getGoodsShowByType(type, name, priceSort, salesSort, gradeSort));
		return PageUtils.getPageResult(pageInfos);
	}

}
