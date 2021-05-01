package com.example.demo.service;


import java.util.ArrayList;

import com.example.demo.bean.audit.BusinessAudit;
import com.example.demo.bean.comment.UserComment;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.user.UserInfo;


public interface AuditService {
     public int insertAudit(BusinessAudit b);
     
     public int updateAudit(int AuditId,int state);
     
     public int getUserState(int userId);
     public ArrayList<BusinessAudit> getAuditByUser(int userId);
     
     public ArrayList<BusinessAudit> getAuditByAdmin(int adminId);
     
     public ArrayList<Goods> getGoodsByAdmin();
     
     public ArrayList<UserComment> getAllComment();
     
     public ArrayList<UserInfo> getAllUser();
     
     public void updateGoodsByAdmin(int state,int goodsId);
     
     public void updateAllComment(int state,int commentId);
     
     public void updateAllUser(int state,int userId);
     
     
}
