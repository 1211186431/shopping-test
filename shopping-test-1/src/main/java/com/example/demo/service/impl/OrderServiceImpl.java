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
	public OrderR getOrderByNum(String orderNum) {
		// TODO Auto-generated method stub
		OrderDetail od=this.oMapper.getOrderByNum(orderNum);
		ArrayList<GoodsUtil> a=this.oMapper.getGoodsUtil(orderNum);
		OrderUtil ou=new OrderUtil();
		return ou.getOrderR(od, a);
	}

	@Override
	public ArrayList<OrderR> getUserOrder(int user_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderDetail> a=this.oMapper.getUserOrder(user_id);
		ArrayList<OrderR> or=new ArrayList<OrderR>();
		OrderUtil ou=new OrderUtil();
		for(int i=0;i<a.size();i++) {
			OrderDetail o=a.get(i);
			ArrayList<GoodsUtil> g=this.oMapper.getGoodsUtil(o.getOrderNumber());
			or.add(ou.getOrderR(o, g));
		}
		return or;
	}

}
