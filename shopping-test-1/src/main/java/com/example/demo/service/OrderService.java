package com.example.demo.service;

import java.util.ArrayList;

import org.quartz.SchedulerException;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderGoods;
import com.example.demo.bean.goods.OrderR;

public interface OrderService {
	/**
	 * 生成订单开启定时任务
	 * @param o
	 * @return
	 * @throws SchedulerException
	 */
    public OrderDetail insertOrder(OrderR o) throws SchedulerException;
    
    /**
     * 更新订单信息
     * @param OrderId
     * @param state
     * @throws SchedulerException
     */
    public void updateOrder(int OrderId,int state) throws SchedulerException;
    
    /**
     * 获取订单信息
     * @param orderNum
     * @return
     */
    public OrderDetail getOrderByNum(String orderNum);
    
    /**
     * 获取用户的全部订单
     * @param user_id
     * @return
     */
    public ArrayList<OrderDetail> getUserOrder(int user_id);
    
    /**
     * 获取订单中的全部商品
     * @param o
     * @return
     */
    public ArrayList<OrderGoods> getOrderGoods(String o);
}
