package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.bean.comment.UserComment;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.dao.auditMapper.BusinessMapper;
import com.example.demo.dao.commentMapper.CommentMapper;
import com.example.demo.dao.goodsMapper.GoodsMapper;
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
    
    @Autowired
    GoodsMapper gMapper;
    
    @Autowired
    CommentMapper cMapper;
    
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
			s.setUserId(userId);
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

	@Override
	public ArrayList<Goods> getGoodsByAdmin() {
		// TODO Auto-generated method stub
		return this.gMapper.getOffGoods();
	}

	@Override
	public ArrayList<UserComment> getAllComment() {
		// TODO Auto-generated method stub
		return this.cMapper.getAllUserComment();
	}

	@Override
	public ArrayList<UserInfo> getAllUser() {
		// TODO Auto-generated method stub
		return this.uMapper.getAllUser();
	}

	@Override
	public void updateGoodsByAdmin(int state,int goodsId) {
		// TODO Auto-generated method stub
		this.gMapper.upDateGoodsState(state,goodsId);
	}

	@Override
	public void updateAllComment(int state, int commentId) {
		// TODO Auto-generated method stub
		this.cMapper.upDateCommentState(state, commentId);
	}

	@Override
	public void updateAllUser(int state, int userId) {
		// TODO Auto-generated method stub
		this.uMapper.updateUserState(state, userId);
	}



}
