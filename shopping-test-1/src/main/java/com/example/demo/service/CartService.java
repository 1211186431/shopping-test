package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.shoppingCart.ShoppingCart;

public interface CartService {
	/**
	 * 通过用户id获取购物车
	 * @param userId
	 * @return
	 */
	public ArrayList<ShoppingCart> getUserCart(int userId);
	
	/**
	 * 加入购物车
	 * @param s
	 * @return
	 */
	public int insertUserCart(ShoppingCart s); 
	
	/**
	 * 更新购物车中的商品数量
	 * @param s
	 */
	public void upDateUserCart(ShoppingCart s);
	
	/**
	 * 删除购物车中的商品
	 * @param id
	 */
	public void deleteUserCart(int id);
	
	/**
	 * 清空购物车
	 * @param userId
	 */
	public void deleteAllCart(int userId);
}
