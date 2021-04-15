package com.example.demo.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.collection.Collection;
import com.example.demo.dao.userMapper.UserCMapper;
import com.example.demo.service.CollectionService;
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired 
    UserCMapper cMapper;
    
	@Override
	public ArrayList<Collection> getCollection(int userId) {
		// TODO Auto-generated method stub
		return this.cMapper.getCollection(userId);
	}

	@Override
	public void insertCollection(Collection c) {
		// TODO Auto-generated method stub
        this.cMapper.insertCollection(c);
	}

}