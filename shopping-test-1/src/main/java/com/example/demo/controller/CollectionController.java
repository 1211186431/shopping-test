package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.collection.Collection;
import com.example.demo.service.CollectionService;
/**
 * 用户收藏类接口
 * @author dy-xx
 *
 */
@RestController
public class CollectionController {
    @Autowired
    CollectionService cService;
    
    /**
     * 获取用户的收藏信息
     * @param userId 用户Id
     * @return  用户收藏列表
     */
    @GetMapping("/collection/get")
    public ArrayList<Collection> getCollection(@RequestParam("userId") int userId){
    	return this.cService.getCollection(userId);
    }
    
    /**
     * 插入收藏
     * @param userId  用户id
     * @param goodsId 商品Id
     * @return
     */
    @PostMapping("/collection/insert")
    public int insertCollection(@RequestParam("userId") int userId,@RequestParam("goodsId") int goodsId) {
    	Collection c=new Collection();
    	c.setCreateDate(new Date());
    	c.setGoods_id(goodsId);
    	c.setUser_id(userId);
    	this.cService.insertCollection(c);
    	return c.getId();
    }
    
    /**
     * 删除用户收藏
     * @param id  收藏表的主键
     */
    @PostMapping("/collection/delete")
    public void deleteCollection(@RequestParam("collId") int id) {
    	this.cService.deleteCollection(id);
    }
}
