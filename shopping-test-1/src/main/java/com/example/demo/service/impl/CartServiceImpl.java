package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.shoppingCart.ShoppingCart;
import com.example.demo.dao.goodsMapper.CartMapper;
import com.example.demo.service.CartService;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cMapper;
	
	@Override
	public ArrayList<ShoppingCart> getUserCart(int userId) {
		// TODO Auto-generated method stub
		return cMapper.getUserCart(userId);
	}

	@Override
	public int insertUserCart(ShoppingCart s) {
		// TODO Auto-generated method stub
		return cMapper.insertUserCart(s);
	}

	@Override
	public void upDateUserCart(ShoppingCart s) {
		// TODO Auto-generated method stub
        this.cMapper.upDateUserCart(s);
	}

	@Override
	public void deleteUserCart(int id) {
		// TODO Auto-generated method stub
        this.cMapper.deleteUserCart(id);
	}

	@Override
	public void deleteAllCart(int userId) {
		// TODO Auto-generated method stub
        this.cMapper.deleteAllCart(userId);
	}

}
