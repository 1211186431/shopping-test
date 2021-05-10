package com.example.demo.dao.auditMapper;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.audit.BusinessAudit;

@Mapper
public interface BusinessMapper extends BaseMapper<BusinessAudit>{
	/**
	 * 通过用户id获取，审核商家消息
	 * @param userId  用户id
	 * @return
	 */
	@Select("select * from business_audit where user_id=#{userId}")
     public ArrayList<BusinessAudit> getBusinessAuditByUserId(int userId); 
	
	/**
	 * 通过审核id获取用户id
	 * @param auditId 审核id
	 * @return
	 */
	@Select("select user_id from business_audit where id=#{auditId}")
	public int getUserId(int auditId);
	
	/**
	 * 获取管理员审核的所有的 审核消息
	 * @param adminId  管理员id
	 * @return
	 */
	@Select("select * from business_audit where admin_id=#{adminId}")
    public ArrayList<BusinessAudit> getBusinessAuditByAdminId(int adminId);
	
	/**
	 * 插入审核消息
	 * @param businessAudit 
	 * @return
	 */
	@Insert("insert into business_audit(user_id,admin_id,certificates,createDate,updateTime)"
	    		+" values(#{user_id},#{admin_id},#{certificates},#{createDate},#{updateTime})")
	public int insertAudit(BusinessAudit businessAudit);
	
	/**
	 * 更新审核状态
	 * @param id
	 * @param updateTime
	 * @param state
	 */
	 @Update("update business_audit set updateTime=#{updateTime},state=#{state} where id=#{id}")
	public void updateAudit(int id,Date updateTime,int state);
}
