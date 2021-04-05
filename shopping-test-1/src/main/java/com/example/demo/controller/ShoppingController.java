package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.ShoppingInfo;
import com.example.demo.service.ShoppingService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
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
	
	
	/*
	 * 上传图片
	 */
	@PostMapping("/shopping/up")
	public void upfile(@RequestParam("file")MultipartFile file) throws IOException {
		if (file == null) return ;
		 
	    String fileName = file.getOriginalFilename();
	    log.info(fileName);
	    FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("D:"+"//" +fileName));
		    IOUtils.copy(file.getInputStream(),fos);
			//将MultipartFile file转成二进制流并输入到FileOutStream
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//打开FileOutStrean流 
	}
	
	@PostMapping("/shopping/session1")
	public String userName(@RequestParam("username") String userName,HttpServletRequest request) {
		String name="";
		HttpSession session = request.getSession();
		session.setAttribute("userN", userName);
		name = (String) session.getAttribute("userN");
		return name;
	}
	
	@GetMapping("/shopping/getSession")
	public String getSession(HttpServletRequest request) {
		String name="";
		HttpSession session = request.getSession();
		name = (String) session.getAttribute("userN");
		return name;
	}
}
