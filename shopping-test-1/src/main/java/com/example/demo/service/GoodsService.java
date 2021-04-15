package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsShow;

public interface GoodsService {
     public ArrayList<Goods> getAllGoods();
     
     public PageResult getAllGoodsShow(int pageNum, int pageSize);
     
     public Goods getGoodsById(int goodsId);
     
     public int insertGoods(Goods g);
     
     public void upDateGoods(Goods g);
}
