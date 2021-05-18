package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsPic;
import com.example.demo.bean.goods.GoodsType;

public interface GoodsService {
     public ArrayList<Goods> getAllGoods();
     
     public PageResult<?> getAllGoodsShow(int pageNum, int pageSize);
     
     public Goods getGoodsById(int goodsId);
     
     public int insertGoods(Goods g);
     
     public void upDateGoods(Goods g);
     
     public ArrayList<Goods> getGoodsBySeller(int sellerId);
     
     public ArrayList<GoodsType> getAllGoodsType();
     
     public int insertGoodsPic(GoodsPic g);
     
     public void upDateGoodsPic(String pic,int goodsId);
     
     public ArrayList<GoodsPic> getGoodsPic(int goodsId);
     
     public void deleteGoodsPic(int id);
     
     public PageResult<?> getGoodsShow(int pageNum, int pageSize,int type,String name,String priceSort
     		,String salesSort,String gradeSort);
}
