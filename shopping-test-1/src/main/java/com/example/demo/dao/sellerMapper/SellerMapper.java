package com.example.demo.dao.sellerMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.seller.SellerInfo;

@Mapper
public interface SellerMapper extends BaseMapper<SellerInfo> {
	/**
	 * 通过商家id获取商家信息
	 * @param userId
	 * @return
	 */
	@Select("select * from seller where userId=#{userId}")
	public SellerInfo getSellerInfoById(int userId);
    
	/**
	 * 通过商品id获取商家信息
	 * @param userId
	 * @return
	 */
	@Select("select s.userId,s.score,s.state,s.sellerName from goods g join seller s on g.user_id=s.userId  where g.id=#{goodsId}")
	public SellerInfo getSellerInfoByGoodsId(int goodsId);
	
	
	/**
	 * 插入商家信息
	 * @param s
	 */
	@Insert("insert into seller(userId,score,state,sellerName)" + " values(#{userId},#{score},#{state},{sellerName})")
	public void insertSellerInfo(SellerInfo s);
}
