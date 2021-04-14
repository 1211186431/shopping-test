package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService oService;
	
    @PostMapping("/Order/set")
    public OrderDetail setOrder(@RequestBody OrderR orderR) {
    	//int orderId=this.oService.insertOrder(orderR);
		return this.oService.insertOrder(orderR);  //需要完善
    }
    
    @PostMapping("/Order/update")
    public String updateOrder(@RequestParam("OrderNum") String OrderNum,@RequestParam("state") int state) {
    	this.oService.updateOrder(OrderNum, state);
    	return "123";
    }
    
    @GetMapping("/Order/get")
    public OrderDetail getOrderDetail(@RequestParam("orderNum") String orderNum){
    	return this.oService.getOrderByNum(orderNum);
    }
}
