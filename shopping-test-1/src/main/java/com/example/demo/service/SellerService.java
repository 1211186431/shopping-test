package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.seller.SellerOrderInfo;

public interface SellerService {
	/**
	 * 获取商家信息
	 * @param userId
	 * @return
	 */
     public SellerInfo getSellerById(int userId);
     
     /**
      * 获取商家的全部订单
      * @param sellerId
      * @return
      */
     public ArrayList<SellerOrderInfo> getSellerOrderInfo(int sellerId);
     
     /**
      * 通过商品获取商家信息
      * @param goodsId
      * @return
      */
     public SellerInfo getSellerByGoodsId(int goodsId);
}
