package com.example.demo.helper;

import java.util.Date;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;

public class OrderUtil {
    public OrderDetail getOrderD(OrderR o) {
    	OrderDetail od=new OrderDetail();
    	od.setAllprice(o.getAllprice());
    	od.setOrderNumber(o.getOrderNumber());
    	od.setPayment(o.getPayment());
    	od.setPurchasingDate(new Date());
    	od.setReceiver(o.getReceiver());
    	od.setUser_id(o.getUserId());
    	od.setState(o.getState());
    	return od;
    }
}
