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
		return this.gMapper.getGoodsById(goodsId);
	}

}
