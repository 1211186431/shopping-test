package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ShoppingInfo;
import com.example.demo.service.ShoppingService;


@RestController
public class ShoppingController {
	@Autowired
	private ShoppingService shoppingService;
	
	@GetMapping("/shopping")
	public List<ShoppingInfo> getAll(){
		return this.shoppingService.getAllInfo();
	}
	
	@GetMapping("/shopping/byId")
	public ShoppingInfo getOne(@RequestParam("id") int id) {
		 return this.shoppingService.getOneInfo(id);
	}
	
	@PostMapping("/shopping/insert")
	public Long insertInfo(@RequestParam("name") String name,@RequestParam("price") int price,@RequestParam("other") String other) {
		ShoppingInfo shoppingInfo =ShoppingInfo.builder().name(name).price(price).other(other).build(); //id设置有问题
		return this.shoppingService.insert(shoppingInfo);
	}
	
	@PostMapping("/shopping/insert/json")
	public Long insertInfo2(@RequestBody ShoppingInfo shoppingInfo) {
		return this.shoppingService.insert(shoppingInfo);
	}
	
	@PutMapping("/shopping/update")
	public void updateInfo(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("price") int price,@RequestParam("other") String other) {
		ShoppingInfo shoppingInfo=ShoppingInfo.builder().id(id).name(name).price(price).other(other).build();
		this.shoppingService.updateById(shoppingInfo);
	}
	
	@DeleteMapping("/shopping/delete")
	public void deleteInfo(@RequestParam("id") int id) {
		this.shoppingService.deleteById(id);
	}
}
