package com.example.demo.dao.sellerMapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.seller.SellerInfo;
import com.example.demo.bean.seller.SellerOrderInfo;

@Mapper
public interface SellerMapper extends BaseMapper<SellerInfo> {
	@Select("select * from seller where userId=#{userId}")
	public SellerInfo getSellerInfoById(int userId);

	@Insert("insert into seller(userId,score,state)" + " values(#{userId},#{score},#{state})")
	public void insertSellerInfo(SellerInfo s);
}
