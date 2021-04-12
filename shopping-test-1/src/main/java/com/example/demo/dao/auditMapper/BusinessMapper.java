package com.example.demo.dao.auditMapper;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.ShoppingInfo;
import com.example.demo.bean.audit.BusinessAudit;

@Mapper
public interface BusinessMapper extends BaseMapper<BusinessAudit>{
	@Select("select * from business_audit where user_id=#{userId}")
     public ArrayList<BusinessAudit> getBusinessAuditByUserId(int userId); 
	
	@Select("select * from business_audit where admin_id=#{adminId}")
    public ArrayList<BusinessAudit> getBusinessAuditByAdminId(int adminId);
	
	@Insert("insert into business_audit(user_id,admin_id,certificates,createDate,updateTime)"
	    		+" values(#{user_id},#{admin_id},#{certificates},#{createDate},#{updateTime})")
	public int insertAudit(BusinessAudit businessAudit);
	
	 @Update("update business_audit set updateTime=#{updateTime},state=#{state} where id=#{id}")
		public void updateAudit(int id,Date updateTime,int state);
}
