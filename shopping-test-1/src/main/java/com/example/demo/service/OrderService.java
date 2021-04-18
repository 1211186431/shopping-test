package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;

public interface OrderService {
    public OrderDetail insertOrder(OrderR o);
    
    public void updateOrder(String orderNum,int state);
    
    public OrderDetail getOrderByNum(String orderNum);
    
    public ArrayList<OrderDetail> getUserOrder(int user_id);
}
