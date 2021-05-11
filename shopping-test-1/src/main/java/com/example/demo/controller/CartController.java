package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.shoppingCart.ShoppingCart;
import com.example.demo.service.CartService;

@RestController
public class CartController {
    @Autowired
    CartService cService;
    
    /**
     * 获取用户的购物车
     * @param userId
     * @return
     */
    @GetMapping("/cart/getCart")
    public ArrayList<ShoppingCart> getUserCart(@RequestParam("userId")int userId){
    	return this.cService.getUserCart(userId);
    }
	
    /**
     * 加入购物车
     * @param s
     * @return
     */
    @PostMapping("/cart/insertCart")
	public int insertUserCart(@RequestBody ShoppingCart s) {
    	this.cService.insertUserCart(s);
		return s.getId();
	}
	
    /**
     * 更新商品数量
     * @param s
     */
    @PostMapping("/cart/updateCart")
	public void upDateUserCart(@RequestBody ShoppingCart s) {
    	this.cService.upDateUserCart(s);
    }
	
    /**
     * 删除购物车中的商品
     * @param id
     */
    @PostMapping("/cart/deleteCart")
	public void deleteUserCart(@RequestParam("cartId") int id) {
    	this.cService.deleteUserCart(id);
    }
	
    /**
     * 清空购物车
     * @param userId
     */
    @PostMapping("/cart/deleteAllCart")
	public void deleteAllCart(int userId) {
    	this.cService.deleteAllCart(userId);
    }
}
