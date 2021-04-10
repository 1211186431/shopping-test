package com.example.demo.service;


import java.util.ArrayList;

import com.example.demo.bean.audit.BusinessAudit;


public interface AuditService {
     public int insertAudit(BusinessAudit b);
     
     public int updateAudit(int userId,int state);
     
     public ArrayList<BusinessAudit> getAuditByUser(int userId);
     
     public ArrayList<BusinessAudit> getAuditByAdmin(int adminId);
     
}
