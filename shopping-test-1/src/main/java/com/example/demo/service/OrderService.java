package com.example.demo.service;

import java.util.ArrayList;

import org.quartz.SchedulerException;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;

public interface OrderService {
    public OrderDetail insertOrder(OrderR o) throws SchedulerException;
    
    public void updateOrder(String orderNum,int state);
    
    public OrderR getOrderByNum(String orderNum);
    
    public ArrayList<OrderR> getUserOrder(int user_id);
}
