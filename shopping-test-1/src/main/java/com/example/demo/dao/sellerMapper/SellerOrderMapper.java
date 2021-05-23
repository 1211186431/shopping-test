package com.example.demo.dao.sellerMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.seller.SellerOrderInfo;
@Mapper
public interface SellerOrderMapper extends BaseMapper<SellerOrderInfo>{
	/**
	 * 获取商家拥有的所有商品的订单信息
	 * @param sellerId
	 * @return
	 */
	@Select("SELECT"
			+ "	myorder.receiver,goods_order.id,goods_order.state,myorder.orderNumber,myorder.purchasingDate,goods.id AS goodsId,goods_order.goodsNum,goods.user_id AS sellerId,myorder.user_id AS userId "
			+ "FROM "
			+ "	goods_order"
			+ "	JOIN goods ON goods_order.goodsId = goods.id "
			+ "	JOIN myorder ON goods_order.orderNumber = myorder.orderNumber"
			+ " where goods.user_id=#{sellerId}")
	public ArrayList<SellerOrderInfo> getSellerOrderInfo(int sellerId);
}
