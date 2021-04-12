package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.SellerInfo;
import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.dao.auditMapper.BusinessMapper;
import com.example.demo.dao.sellerMapper.SellerMapper;
import com.example.demo.dao.userMapper.UserMapper;
import com.example.demo.service.AuditService;
@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    BusinessMapper bMapper;
    
    @Autowired
    UserMapper uMapper;
    
    @Autowired
    SellerMapper sMapper;
    
	@Override
	public int insertAudit(BusinessAudit b) {
		// TODO Auto-generated method stub
        ArrayList<Integer> adminIdList=this.uMapper.getAdminId();
        Random rand = new Random();
        int x=rand.nextInt(adminIdList.size());
        b.setAdmin_id(adminIdList.get(x));
        this.bMapper.insertAudit(b);
		return adminIdList.get(x);
	}

	@Override
	public int updateAudit(int AuditId,int state) {
		// TODO Auto-generated method stub
		this.bMapper.updateAudit(AuditId,new Date(),state);
		if(state==1) {
			SellerInfo s=new SellerInfo();
			int userId=this.bMapper.getUserId(AuditId);
			s.setUser_id(userId);
			this.sMapper.insertSellerInfo(s);
			this.uMapper.updateUserRole("ROLR_admin", userId);
		}
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

	@Override
	public int getUserState(int userId) {
		// TODO Auto-generated method stub
		return this.uMapper.getUserState(userId);
	}

}
