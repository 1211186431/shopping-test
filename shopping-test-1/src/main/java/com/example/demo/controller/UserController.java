package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.user.UserAddress;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.orderJob.MyFirstJob;
import com.example.demo.orderJob.QuartzConfig;
import com.example.demo.service.UserService;


/**
 * 用户信息接口
 * @author dy-xx
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	QuartzConfig q;
	/**
	 * 获取所有的用户 的信息
	 * @return
	 */
	@GetMapping("/getAll")
	public List<UserInfo> getAll(){
		return this.userService.getAllUser();
	}
	
	/**
	 * 注册，必填项
	 * @param name   
	 * @param password
	 * @param phone
	 * @return
	 */
	@PostMapping("/register")
	public Map<String,String> register(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("phone") String phone){
		UserInfo userInfo=new UserInfo(name,password,phone,"ROLE_user");
		
		Map<String,String> map=new HashMap<>();
		String s=this.userService.insertOne(userInfo);
		map.put("msg", s);
		if(s.equals("创建成功")) {
			map.put("state","1");
		}
		else {
		   map.put("state", "0");	
		}
		return map;
	}
	
	/**
	 * 获取用户信息
	 * @param userId  用户id
	 * @return
	 */
	@GetMapping("/user/getUserInfo")
	public UserInfo getUserInfo(@RequestParam("userId") int userId) {
		return this.userService.getUserInfo(userId);
	}
	
	/**
	 * 更新用户信息
	 * @param email
	 * @param location
	 * @param phone
	 * @param sex
	 * @param userId
	 * @return
	 */
	@PostMapping("/user/UpDateInfo")
	public String UpdateUserInfo(@RequestParam("email")String email,
			@RequestParam("location")String location,@RequestParam("phone")String phone,
			@RequestParam("sex")int sex,@RequestParam("userId")int userId) {
		this.userService.UpdateUserInfo(email, location, phone, sex, userId);
		return "1";
	}
	
	/**
	 * 获取用户住址
	 * @param userId  用户住址
	 * @return 用户住址列表
	 */
	@GetMapping("/user/getUserAddress")
	public ArrayList<UserAddress> getUserAddress(@RequestParam("userId") int userId) {
		return this.userService.getUserAddress(userId);
	}
	
	/**
	 * 插入用户住址
	 * @param address
	 * @param phone
	 * @param userId
	 * @return  住址id
	 */
	@PostMapping("/user/insertAddress")
	public int insertAddress(@RequestParam("address")String address,
			@RequestParam("phone")String phone,@RequestParam("userId")int userId) {
		return this.userService.insertUserAddress(userId, phone, address);
	}
	
	/**
	 * 获取所有用户+管理员 测试用
	 * @return
	 * @throws SchedulerException 
	 */
	@GetMapping("/user/getAll2")
	public List<UserInfo> getAllPeople() throws SchedulerException {
	   Map<String,Object> params=new HashMap<String,Object>();
	   params.put("name", "123");
	   q.task(new MyFirstJob(), params,"111");
		return this.userService.getAll();
	}
   
}
