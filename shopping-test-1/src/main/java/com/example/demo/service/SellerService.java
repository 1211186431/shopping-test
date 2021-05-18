package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.seller.SellerOrderInfo;

public interface SellerService {
     public SellerInfo getSellerById(int userId);
     
     public ArrayList<SellerOrderInfo> getSellerOrderInfo(int sellerId);
     
     public SellerInfo getSellerByGoodsId(int goodsId);
}
