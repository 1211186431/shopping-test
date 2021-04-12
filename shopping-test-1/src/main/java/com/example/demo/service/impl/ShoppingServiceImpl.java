package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PageResult;
import com.example.demo.bean.ShoppingInfo;
import com.example.demo.dao.mapper.InfoMapper;
import com.example.demo.helper.PageUtils;
import com.example.demo.service.ShoppingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ShoppingServiceImpl implements ShoppingService {
    
	@Autowired
	private InfoMapper infoMapper; 
	
	@Override
	public List<ShoppingInfo> getAllInfo() {
		// TODO Auto-generated method stub
		return this.infoMapper.getInfo();
	}

	@Override
	public ShoppingInfo getOneInfo(int id) {
		// TODO Auto-generated method stub
		return this.infoMapper.getOne(id);
	}

	@Override
	public Long insert(ShoppingInfo shoppingInfo) {
		// TODO Auto-generated method stub
		return this.infoMapper.insertOne(shoppingInfo);
	}

	@Override
	public void updateById(ShoppingInfo shoppingInfo) {
		// TODO Auto-generated method stub
        this.infoMapper.updateInfo(shoppingInfo);;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
        this.infoMapper.delete(id);
	}

	@Override
	public PageResult getPageShopping(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<ShoppingInfo> pageInfos = new PageInfo<>(this.infoMapper.getInfo());
		
		
		return PageUtils.getPageResult(pageInfos);
	}

}
