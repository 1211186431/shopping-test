package com.example.demo.helper;

import java.util.ArrayList;
import java.util.Date;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;

public class OrderUtil {
    public OrderDetail getOrderD(OrderR o) {
    	OrderDetail od=new OrderDetail();
    	od.setAllprice(o.getAllprice());
    	od.setOrderNumber(o.getOrderNumber());
    	od.setPayment(o.getPayment());
    	od.setPurchasingDate(o.getPurchasingDate());
    	od.setReceiver(o.getReceiver());
    	od.setUser_id(o.getUserId());
    	od.setState(o.getState());
    	return od;
    }
    
    public OrderR getOrderR(OrderDetail o,ArrayList<GoodsUtil> g) {
    	OrderR or=OrderR.builder().orderNumber(o.getOrderNumber()).Allprice(o.getAllprice())
    			.payment(o.getPayment()).receiver(o.getReceiver()).state(o.getState()).userId(o.getUser_id())
    			.purchasingDate(o.getPurchasingDate()).goodsList(g).build();
    	return or;
    }
    
}
