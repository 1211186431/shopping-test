package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.dao.auditMapper.BusinessMapper;
import com.example.demo.service.AuditService;
@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    BusinessMapper bMapper;
    
	@Override
	public int insertAudit(BusinessAudit b) {
		// TODO Auto-generated method stub
		return this.bMapper.insertAudit(b);
	}

	@Override
	public int updateAudit(int userId,int state) {
		// TODO Auto-generated method stub
		this.bMapper.updateAudit(userId,new Date(),state);
		
		return 1;
	}

	@Override
	public ArrayList<BusinessAudit> getAuditByUser(int userId) {
		// TODO Auto-generated method stub
		return this.bMapper.getBusinessAuditByUserId(userId);
	}

	@Override
	public ArrayList<BusinessAudit> getAuditByAdmin(int adminId) {
		// TODO Auto-generated method stub
		return this.bMapper.getBusinessAuditByAdminId(adminId);
	}

}
