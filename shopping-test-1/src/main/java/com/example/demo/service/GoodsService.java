package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsPic;
import com.example.demo.bean.goods.GoodsType;

public interface GoodsService {
	/**
	 * 获取全部商品
	 * @return
	 */
     public ArrayList<Goods> getAllGoods();
     
     /**
      * 获取全部商品（分页）
      * @param pageNum
      * @param pageSize
      * @return
      */
     public PageResult<?> getAllGoodsShow(int pageNum, int pageSize);
     
     /**
      * 通过商品id获取商品
      * @param goodsId
      * @return
      */
     public Goods getGoodsById(int goodsId);
     
     /**
      * 插入商品
      * @param g
      * @return
      */
     public int insertGoods(Goods g);
     
     /**
      * 更新商品
      * @param g
      */
     public void upDateGoods(Goods g);
     
     /**
      * 获取商家的全部商品
      * @param sellerId
      * @return
      */
     public ArrayList<Goods> getGoodsBySeller(int sellerId);
     
     /**
      * 获取所有的商品种类
      * @return
      */
     public ArrayList<GoodsType> getAllGoodsType();
     
     /**
      * 插入商品图片
      * @param g
      * @return
      */
     public int insertGoodsPic(GoodsPic g);
     
     /**
      * 更新商品图片
      * @param pic
      * @param goodsId
      */
     public void upDateGoodsPic(String pic,int goodsId);
     
     /**
      * 获取商品的全部图片
      * @param goodsId
      * @return
      */
     public ArrayList<GoodsPic> getGoodsPic(int goodsId);
     
     /**
      * 删除商品的图片
      * @param id
      */
     public void deleteGoodsPic(int id);
     
     /**
      * 按需获取商品（新）
      * @param pageNum
      * @param pageSize
      * @param type
      * @param name
      * @param priceSort
      * @param salesSort
      * @param gradeSort
      * @return
      */
     public PageResult<?> getGoodsShow(int pageNum, int pageSize,int type,String name,String priceSort
     		,String salesSort,String gradeSort);

    /**
     * 更新商品状态
     * @param state
     * @param goodsId
     */
	public void updateGoodsState(int state, int goodsId);
}
