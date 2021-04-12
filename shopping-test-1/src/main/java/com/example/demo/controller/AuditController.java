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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.service.AuditService;

@RestController
public class AuditController {
	@Autowired
	AuditService auditService;
	
	@GetMapping("/Audit/admin/getAudit/admin")
	public ArrayList<BusinessAudit> getAuditByAdmin(@RequestParam("adminId") int adminId){
		return this.auditService.getAuditByAdmin(adminId);
	}
	
	@GetMapping("/Audit/admin/getAudit/user")
	public ArrayList<BusinessAudit> getAuditByUser(@RequestParam("userId") int userId){
		return this.auditService.getAuditByUser(userId);
	}
	
	@PostMapping("/Audit/admin/updateAudit")
	public String updateAudit(@RequestParam("AuditId") int AuditId,int state) {
		this.auditService.updateAudit(AuditId, state);
		return "修改成功";
	}
	
	@PostMapping("/Audit/insert")
	public Map<String,Object> insertAudit(@RequestParam("certificates")MultipartFile file,@RequestParam("userId") int userId)  throws IOException{
		int state=this.auditService.getUserState(userId);
		Map<String,Object> map=new HashMap<>(); 
		if(state==1) {
			BusinessAudit b=new BusinessAudit();
			b.setUser_id(userId);
			Date today=new Date();
			b.setUpdateTime(today);
			b.setCreateDate(today);
			if (file == null) {
				map.put("state", 0);
				map.put("msg", "文件上传失败");
				return map;
			}
		    String fileName = "src/main/resources/static/audit/"+userId+"_"+file.getOriginalFilename();
		    FileOutputStream fos;
			try {
				fos = new FileOutputStream(new File(fileName));
			    IOUtils.copy(file.getInputStream(),fos);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			b.setCertificates("/audit/"+userId+"_"+file.getOriginalFilename());
			int AuditId=this.auditService.insertAudit(b);
			map.put("msg", "提交成功，审核管理员编号："+AuditId);
			map.put("state", 1);
			return map;
		}
		else {
			map.put("state", 0);
			map.put("msg", "账户问题，请联系管理员");
			return map;
		}
		
	}
}
