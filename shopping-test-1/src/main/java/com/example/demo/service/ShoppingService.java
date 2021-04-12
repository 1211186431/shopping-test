package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.ShoppingInfo;

public interface ShoppingService {
	/*
	 * 查询全部信息
	 */
    public List<ShoppingInfo> getAllInfo();
    
    /**
     * 查询单个信息
     */
    public ShoppingInfo getOneInfo(int id);
    
    public Long insert(ShoppingInfo shoppingInfo);
    
    public void updateById(ShoppingInfo shoppingInfo);
    
    public void deleteById(int id);
    
     public PageResult getPageShopping(int pageNum, int pageSize);
}
