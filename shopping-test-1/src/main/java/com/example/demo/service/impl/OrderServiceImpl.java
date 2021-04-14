package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;
import com.example.demo.dao.goodsMapper.GoodsMapper;
import com.example.demo.dao.orderMapper.OrderMapper;
import com.example.demo.helper.GoodsUtil;
import com.example.demo.helper.OrderUtil;
import com.example.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper oMapper;
    
    @Autowired
    GoodsMapper gMapper;
    
	@Override
	public OrderDetail insertOrder(OrderR o) {
		// TODO Auto-generated method stub
		OrderUtil ou=new OrderUtil();
		OrderDetail orderD=ou.getOrderD(o);
		this.oMapper.insertOrder(orderD);
		for(int i=0;i<o.getGoodsList().size();i++) {
			this.oMapper.insertGoodsOrdet(o.getOrderNumber(), o.getGoodsList().get(i).getGoodsId(), o.getGoodsList().get(i).getGoodsNum());
		}
		
		return orderD;
	}

	@Override
	public void updateOrder(String o, int state) {
		// TODO Auto-generated method stub
        this.oMapper.updateOrder(o, state);
	}

	@Override
	public OrderDetail getOrderByNum(String orderNum) {
		// TODO Auto-generated method stub
		return this.oMapper.getOrderByNum(orderNum);
	}

}
