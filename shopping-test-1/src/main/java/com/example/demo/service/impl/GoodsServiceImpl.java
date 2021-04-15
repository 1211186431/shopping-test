package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsShow;
import com.example.demo.dao.goodsMapper.GoodsMapper;
import com.example.demo.helper.PageUtils;
import com.example.demo.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired 
    private GoodsMapper gMapper;
    
	@Override
	public ArrayList<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return this.gMapper.getAllGoods();
	}

	@Override
	public PageResult getAllGoodsShow(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		PageInfo pageInfos=new PageInfo<>(this.gMapper.getGoodsShow());
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
		return goodsId;
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

}
