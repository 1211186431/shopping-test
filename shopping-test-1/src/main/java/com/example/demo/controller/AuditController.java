package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.bean.comment.UserComment;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.helper.StaticSource;
import com.example.demo.service.AuditService;
/**
 * 管理员审核相关接口
 * @author dy-xx
 *
 */
@RestController
public class AuditController {
	@Autowired
	AuditService auditService;
	@Autowired
    private StaticSource messageSource;
	
	/**
	 * 获取管理员审核的所有信息
	 * @param adminId 管理员Id
	 * @return
	 */
	@GetMapping("/Audit/admin/getAudit/admin")
	public ArrayList<BusinessAudit> getAuditByAdmin(@RequestParam("adminId") int adminId) {
		return this.auditService.getAuditByAdmin(adminId);
	}
    
	/**
	 * 获取用户申请的所有信息
	 * @param userId  用户Id
	 * @return
	 */
	@GetMapping("/Audit/admin/getAudit/user")
	public ArrayList<BusinessAudit> getAuditByUser(@RequestParam("userId") int userId) {
		return this.auditService.getAuditByUser(userId);
	}
    
	/**
	 * 管理员更新审核状态
	 * @param AuditId 审核信息的Id
	 * @param state  更新后的状态
	 * @return
	 */
	@PostMapping("/Audit/admin/updateAudit")
	public String updateAudit(@RequestParam("AuditId") int AuditId, int state) {
		this.auditService.updateAudit(AuditId, state);
		return "修改成功";
	}

	/**
	 * 上传图片，保存,添加审核表信息
	 * @param file  图片 
	 * @param userId  用户Id
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/audit/insert")
	public Map<String, Object> insertAudit(@RequestParam("certificates") MultipartFile file,
			@RequestParam("userId") int userId) throws IOException {
		String url = messageSource.getPicurl();
		int state = this.auditService.getUserState(userId);
		Map<String, Object> map = new HashMap<>();
		if (state == 1) {
			BusinessAudit b = new BusinessAudit();
			b.setUser_id(userId);
			Date today = new Date();
			b.setUpdateTime(today);
			b.setCreateDate(today);
			if (file == null) {
				map.put("state", 0);
				map.put("msg", "文件上传失败");
				return map;
			}
			String fileName = url+"/audit/" + userId + "_" + file.getOriginalFilename();
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(new File(fileName));
				IOUtils.copy(file.getInputStream(), fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			b.setCertificates("/audit/" + userId + "_" + file.getOriginalFilename());
			int AuditId = this.auditService.insertAudit(b);
			map.put("msg", "提交成功，审核管理员编号：" + AuditId);
			map.put("state", 1);
			return map;
		} else {
			map.put("state", 0);
			map.put("msg", "账户问题，请联系管理员");
			return map;
		}

	}
    
	/**
	 * 获取审核未通过商品
	 * @return 
	 */
	@GetMapping("/Audit/getOffGoods")
	public ArrayList<Goods> getOffGoods() {
		return this.auditService.getGoodsByAdmin();
	}
    
	/**
	 * 获取全部用户
	 * @return
	 */
	@GetMapping("/Audit/getAllUser")
	public ArrayList<UserInfo> getUserByAdmin() {
		return this.auditService.getAllUser();
	}
    
	/**
	 * 获取全部评论
	 * @return
	 */
	@GetMapping("/Audit/getAllComment")
	public ArrayList<UserComment> getCommentByAdmin() {
		return this.auditService.getAllComment();
	}

	/**
	 * 设置商品状态
	 * @param goodsId 商品Id
	 * @param state  状态
	 */
	@PostMapping("/Audit/update/goods")
	public void upDateGoodsState(@RequestParam("goodsId") int goodsId, @RequestParam("state") int state) {
		this.auditService.updateGoodsByAdmin(state, goodsId);
	}
    
	/**
	 * 设置评论状态
	 * @param commentId  评论Id
	 * @param state  状态
	 */
	@PostMapping("/Audit/update/comment")
	public void upDateCommentState(@RequestParam("commentId") int commentId, @RequestParam("state") int state) {
		this.auditService.updateAllComment(state, commentId);
	}
	
	/**
	 * 设置用户状态
	 * @param userId  用户Id
	 * @param state  状态
	 */
	@PostMapping("/Audit/update/user")
	public void upDateUserState(@RequestParam("userId") int userId, @RequestParam("state") int state) {
		this.auditService.updateAllUser(state, userId);
	}
}
