package com.example.demo.dao.sellerMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.seller.SellerInfo;

@Mapper
public interface SellerMapper extends BaseMapper<SellerInfo> {
	/**
	 * 获取商家信息
	 * @param userId
	 * @return
	 */
	@Select("select * from seller where userId=#{userId}")
	public SellerInfo getSellerInfoById(int userId);
    
	/**
	 * 插入商家信息
	 * @param s
	 */
	@Insert("insert into seller(userId,score,state)" + " values(#{userId},#{score},#{state})")
	public void insertSellerInfo(SellerInfo s);
}
