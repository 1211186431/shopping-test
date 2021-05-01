package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.seller.SellerOrderInfo;
import com.example.demo.service.SellerService;

@RestController
public class SellerController {
     @Autowired
     SellerService sService;
     
     @GetMapping("/seller/getById")
     public SellerInfo getSellerById(@RequestParam("userId") int userId) {
    	 return this.sService.getSellerById(userId);
     }
     
     @GetMapping("/seller/getSellerOrder")
     public ArrayList<SellerOrderInfo> getSellerOrderInfo(@RequestParam("sellerId") int sellerId) {
    	 return this.sService.getSellerOrderInfo(sellerId);
     }
}
