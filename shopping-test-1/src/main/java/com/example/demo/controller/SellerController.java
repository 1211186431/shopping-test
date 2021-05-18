package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.seller.SellerOrderInfo;
import com.example.demo.service.SellerService;
/**
 * 商家信息接口
 * @author dy-xx
 *
 */
@RestController
public class SellerController {
     @Autowired
     SellerService sService;
     
     /**
      * 获取商家详细信息
      * @param userId  用户id
      * @return
      */
     @GetMapping("/seller/getById")
     public SellerInfo getSellerById(@RequestParam("userId") int userId) {
    	 return this.sService.getSellerById(userId);
     }
     
     /**
      * 通过商家id获取商家的订单
      * @param sellerId 商家id
      * @return 商家订单列表
      */
     @GetMapping("/seller/getSellerOrder")
     public ArrayList<SellerOrderInfo> getSellerOrderInfo(@RequestParam("sellerId") int sellerId) {
    	 return this.sService.getSellerOrderInfo(sellerId);
     }
     
     /**
      * 通过商品id获取商家信息
      * @param sellerId 商家id
      * @return 商家订单列表
      */
     @GetMapping("/seller/getSellerInfoByGoods")
     public SellerInfo getSellerInfoByGoodsId(@RequestParam("goodsId") int goodsId) {
    	 return this.sService.getSellerByGoodsId(goodsId);
     }
}
