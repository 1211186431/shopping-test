package com.example.demo.dao.sellerMapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.SellerInfo;

@Mapper
public interface SellerMapper extends BaseMapper<SellerInfo>{
	 @Select("select * from seller")
	public List<SellerInfo> getSellerInfo();
	 
	   @Insert("insert into seller(user_id,score,state)"
	    		+" values(#{user_id},#{score},#{state})")
		public void insertSellerInfo(SellerInfo s);
}
