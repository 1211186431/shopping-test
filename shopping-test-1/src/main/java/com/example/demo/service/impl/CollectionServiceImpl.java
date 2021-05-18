package com.example.demo.service.impl;

import java.util.ArrayList;
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
	public int insertCollection(Collection c) {
		// TODO Auto-generated method stub
		ArrayList<Integer> goodsIds=this.cMapper.getUserCollGoods(c.getUser_id());
		if(goodsIds.contains(c.getGoods_id())) {
			return 0;
		}
		else {
			this.cMapper.insertCollection(c);
			return 1;
		}
        
	}

	@Override
	public void deleteCollection(int id) {
		// TODO Auto-generated method stub
		this.cMapper.deleteCollGoods(id);
	}

}
