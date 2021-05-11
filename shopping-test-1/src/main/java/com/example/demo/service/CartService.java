package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.shoppingCart.ShoppingCart;

public interface CartService {
	public ArrayList<ShoppingCart> getUserCart(int userId);
	
	public int insertUserCart(ShoppingCart s); 
	
	public void upDateUserCart(ShoppingCart s);
	
	public void deleteUserCart(int id);
	
	public void deleteAllCart(int userId);
}
