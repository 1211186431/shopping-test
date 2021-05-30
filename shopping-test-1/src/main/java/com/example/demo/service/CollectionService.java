package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.collection.Collection;

public interface CollectionService {
	/**
	 * 获取用户的收藏列表
	 * @param userId
	 * @return
	 */
     public ArrayList<Collection> getCollection(int userId);
     
     /**
      * 插入收藏
      * @param c
      * @return
      */
     public int insertCollection(Collection c);
     
     /**
      * 删除收藏
      * @param id
      */
     public void deleteCollection(int id);
}
