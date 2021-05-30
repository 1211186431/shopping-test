package com.example.demo.service;


import java.util.ArrayList;

import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.bean.comment.UserComment;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.user.UserInfo;


public interface AuditService {
	/**
	 * 插入审核信息
	 * @param b
	 * @return
	 */
     public int insertAudit(BusinessAudit b);
     
     /**
      * 更新订单状态
      * @param AuditId
      * @param state
      * @return
      */
     public int updateAudit(int AuditId,int state);
     
     /**
      * 获取用户id
      * @param userId
      * @return
      */
     public int getUserState(int userId);
     
     /**
      * 获取用户的审核信息
      * @param userId
      * @return
      */
     public ArrayList<BusinessAudit> getAuditByUser(int userId);
     
     /**
      * 获取管理员审核的信息
      * @param adminId
      * @return
      */
     public ArrayList<BusinessAudit> getAuditByAdmin(int adminId);
     
     /**
      * 管理员获取全部的商品
      * @return
      */
     public ArrayList<Goods> getGoodsByAdmin();
     
     /**
      * 管理员获取全部的评论
      * @return
      */
     public ArrayList<UserComment> getAllComment();
     
     /**
      * 管理员获取全部的用户
      * @return
      */
     public ArrayList<UserInfo> getAllUser();
     
     /**
      * 管理员更新订单状态
      * @param state
      * @param goodsId
      */
     public void updateGoodsByAdmin(int state,int goodsId);
     
     /**
      * 管理员更新评论状态
      * @param state
      * @param commentId
      */
     public void updateAllComment(int state,int commentId);
     
     /**
      * 管理员更新订单状态
      * @param state
      * @param userId
      */
     public void updateAllUser(int state,int userId);
     
     
}
