package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.collection.Collection;
import com.example.demo.service.CollectionService;

@RestController
public class CollectionController {
    @Autowired
    CollectionService cService;
    
    @GetMapping("/collection/get")
    public ArrayList<Collection> getCollection(@RequestParam("userId") int userId){
    	return this.cService.getCollection(userId);
    }
    
    @PostMapping("/collection/insert")
    public int insertCollection(@RequestParam("userId") int userId,@RequestParam("goodsId") int goodsId) {
    	Collection c=new Collection();
    	c.setCreateDate(new Date());
    	c.setGoods_id(goodsId);
    	c.setUser_id(userId);
    	return this.cService.insertCollection(c);
    }
    
    @PostMapping("/collection/delete")
    public void deleteCollection(@RequestParam("collId") int id) {
    	this.cService.deleteCollection(id);
    }
}
