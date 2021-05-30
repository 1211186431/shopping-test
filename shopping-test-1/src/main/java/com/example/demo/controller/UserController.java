package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ImageCode.ImageVerificationCode;
import com.example.demo.bean.user.UserAddress;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.orderJob.MyFirstJob;
import com.example.demo.orderJob.QuartzConfig;
import com.example.demo.responseData.ResponseData;
import com.example.demo.responseData.ResponseDataUtil;
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
	public ResponseData<?> register(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("phone") String phone){
		UserInfo userInfo=new UserInfo(name,password,phone,"ROLE_user");
		String s=this.userService.insertOne(userInfo);
		if(s.equals("创建成功")) {
			return ResponseDataUtil.buildSuccess("200",s);
		}
		else {
			return ResponseDataUtil.buildSuccess("401",s);
		}
	}
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/getVerifiCode")
    public void getVerifiCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
             1.生成验证码
             2.把验证码上的文本存在session中
             3.把验证码图片发送给客户端
             */
        ImageVerificationCode ivc = new ImageVerificationCode();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = ivc.getImage();  //获取验证码
        request.getSession().setAttribute("text", ivc.getText()); //将验证码的文本存在session中
        ImageVerificationCode.output(image, response.getOutputStream());//将验证码图片响应给客户端
    }
	
	/**
	 * 判断验证码
	 * @param request
	 * @param imageCode
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/checkCode")
    public Map<String,Object> checkCode(HttpServletRequest request,@RequestParam("imageCode") String imageCode) throws IOException {
        Map<String,Object> map=new  HashMap<String,Object>();
        String code=(String) request.getSession().getAttribute("text");
        if(code!=null && code.equals(imageCode))
        	map.put("msg", "正确");
        else
        	map.put("msg", "错误");
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
			@RequestParam("phone")String phone,@RequestParam("userId")int userId,@RequestParam("receiver") String receiver) {
		return this.userService.insertUserAddress(userId, phone, address,receiver);
	}
	
	/**
	 * 获取具体的收货信息
	 * @param id
	 * @return
	 */
	@GetMapping("/user/getAddressById")
	public UserAddress getAddressById(@RequestParam("id") int id) {
		return this.userService.getAddressById(id);
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
   
	/**
	 * 更新用户收货地址
	 * @param userId
	 * @param phone
	 * @param address
	 * @param receiver
	 * @param id
	 */
	@PostMapping("/user/updateAddress")
	public void updateAddress(@RequestParam("userId")int userId, @RequestParam("phone")String phone, @RequestParam("address")String address, @RequestParam("receiver")String receiver,@RequestParam("id")int id) {
		this.userService.UpdateAddress(userId, phone, address, receiver, id);
	}
	
	/**
	 * 更新用户收货地址
	 * @param id
	 */
	@PostMapping("/user/deleteAddress")
	public void deleteAddress(@RequestParam("id")int id) {
		this.userService.DeleteAddress(id);
	}
}
