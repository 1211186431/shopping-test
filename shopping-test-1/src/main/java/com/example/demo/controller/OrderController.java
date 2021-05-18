package com.example.demo.controller;

import java.util.ArrayList;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderGoods;
import com.example.demo.bean.goods.OrderR;
import com.example.demo.service.OrderService;
/**
 * 订单接口
 * @author dy-xx
 *
 */
@RestController
public class OrderController {
	@Autowired
	OrderService oService;
	
	/**
	 * 生成订单
	 * @param orderR 前端传送的订单信息
	 * @return
	 * @throws SchedulerException 
	 */
    @PostMapping("/Order/set")
    public OrderDetail setOrder(@RequestBody OrderR orderR) throws SchedulerException {
		return this.oService.insertOrder(orderR);  
    }
    
    /**
     * 更新订单状态
     * @param OrderNum 订单号
     * @param state  状态
     * @return
     */
    @PostMapping("/Order/update")
    public String updateOrder(@RequestParam("OrderNum") String OrderNum,@RequestParam("state") int state) {
    	this.oService.updateOrder(OrderNum, state);
    	return "ok";
    }
    
    /**
     * 获取订单信息
     * @param orderNum  订单号
     * @return
     */
    @GetMapping("/Order/get")
    public OrderDetail getOrderDetail(@RequestParam("orderNum") String orderNum){
    	return this.oService.getOrderByNum(orderNum);
    }
    
    /**
     * 获取用户的所有订单
     * @param user_id  用户id
     * @return
     */
    @GetMapping("/Order/getUserOrder")
    public ArrayList<OrderDetail> getUserOrder(@RequestParam("userId")int user_id){
    	return this.oService.getUserOrder(user_id);
    }
    
    /**
     * 获取订单中的商品具体信息
     * @param orderNum
     * @return
     */
    @GetMapping("/Order/getOrderGoods")
    public ArrayList<OrderGoods> getOrderGoods(@RequestParam("orderNum")String orderNum){
    	return this.oService.getOrderGoods(orderNum);
    }
}
