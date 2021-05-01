package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.seller.SellerOrderInfo;
import com.example.demo.dao.sellerMapper.SellerMapper;
import com.example.demo.dao.sellerMapper.SellerOrderMapper;
import com.example.demo.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService{
    @Autowired
    SellerMapper sMapper;
    
    @Autowired
    SellerOrderMapper soMapper;
    
	@Override
	public SellerInfo getSellerById(int userId) {
		// TODO Auto-generated method stub
		return this.sMapper.getSellerInfoById(userId);
	}

	@Override
	public ArrayList<SellerOrderInfo> getSellerOrderInfo(int sellerId) {
		// TODO Auto-generated method stub
		return this.soMapper.getSellerOrderInfo(sellerId);
	}
    
}
