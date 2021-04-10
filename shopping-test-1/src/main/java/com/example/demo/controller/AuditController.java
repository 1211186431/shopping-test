package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
	
	@GetMapping("/Audit/admin/getAudit")
	public ArrayList<BusinessAudit> getAuditByAdmin(@RequestParam("adminId") int adminId){
		return this.auditService.getAuditByAdmin(adminId);
	}
	
	@PostMapping("/Audit/admin/updateAudit")
	public int updateAudit(@RequestParam("userId") int userId,int state) {
		return this.auditService.updateAudit(userId, state);
	}
	
	@PostMapping("/Audit/insert")
	public int insertAudit(@RequestParam("certificates")MultipartFile file,@RequestParam("userId") int userId)  throws IOException{
		BusinessAudit b=new BusinessAudit();
		b.setAdmin_id(1);
		b.setUser_id(userId);
		Date today=new Date();
		b.setUpdateTime(today);
		b.setCreateDate(today);
		if (file == null) 
			return 0;
	    String fileName = "src/main/resources/static/audit/"+userId+"_"+file.getOriginalFilename();
	    FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(fileName));
		    IOUtils.copy(file.getInputStream(),fos);
			//将MultipartFile file转成二进制流并输入到FileOutStream
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//打开FileOutStrean流 
		b.setCertificates("/audit/"+userId+"_"+file.getOriginalFilename());
		return this.auditService.insertAudit(b);
	}
}
