package com.example.demo.dao.goodsMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.shoppingCart.ShoppingCart;

@Mapper
public interface CartMapper extends BaseMapper<ShoppingCart>{
	/**
	 * 查询用户的购物车
	 * @param userId
	 * @return
	 */
	@Select("select * from shoppingCart where userId=#{userId}")
	public ArrayList<ShoppingCart> getUserCart(int userId);
	
	/**
	 * 加入购物车
	 * @param s
	 * @return
	 */
	@Insert("insert into shoppingCart(userId,goodsId,goodsNum)"
			+ " value(#{userId},#{goodsId},#{goodsNum})")
	@SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
	public int insertUserCart(ShoppingCart s); 
	
	/**
	 * 更新购物车数量
	 * @param s
	 */
	@Update("update shoppingCart set goodsNum=#{goodsNum} where id=#{id}")
	public void upDateUserCart(ShoppingCart s);
	
	/**
	 * 删除购物车某一条信息
	 * @param id
	 */
	@Delete("delete from shoppingCart where id = #{id}")
	public void deleteUserCart(int id);
	
	/**
	 * 清空用户购物车
	 * @param userId
	 */
	@Delete("delete from shoppingCart where userId = #{userId}")
	public void deleteAllCart(int userId);
}
