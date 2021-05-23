package com.example.demo.dao.orderMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderGoods;

@Mapper
public interface OrderMapper extends BaseMapper<OrderDetail>{
	/**
	 * 插入商品
	 * @param o
	 * @return
	 */
    @Insert("insert into Myorder(orderNumber,user_id,Allprice,purchasingDate,receiver,state,payment)"
    		+ " values(#{orderNumber},#{user_id},#{Allprice},#{purchasingDate},#{receiver},#{state},#{payment}) ")
    public int insertOrder(OrderDetail o);
    
    /**
     * 按照订单号更新订单状态
     * @param orderNumber
     * @param state
     */
    @Update("update Myorder set state=#{state} where orderNumber=#{orderNumber}")
    public void updateOrder(String orderNumber,int state);
    
    /**
     * 通过订单号查询订单信息
     * @param orderNumber
     * @return
     */
    @Select("select * from Myorder where orderNumber=#{orderNumber}")
    public OrderDetail getOrderByNum(String orderNumber);
    
    /**
     * 获取用户的所有订单信息
     * @param user_id
     * @return
     */
    @Select("select * from Myorder where user_id=#{user_id}")
    public ArrayList<OrderDetail> getUserOrder(int user_id);
    
   
    @Insert("insert into goods_order(orderNumber,goodsId,goodsNum,state) "
    		+ "values(#{orderNumber},#{goodsId},#{goodsNum},#{state})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public void insertGoodsOrdet(OrderGoods o);
    
    
    @Update("update goods_order set state=#{state} where id=#{id}")
    public void upDateGoodsOrdet(int id,int state);
    
    /**
     * 订单信息辅助
     * @param o
     * @return
     */
    @Select("select a.id,orderNumber,goodsId,goodsNum,a.state,name,price,picture from goods_order a JOIN goods g ON a.goodsId=g.id  where orderNumber=#{o}")
    public ArrayList<OrderGoods> getGoodsUtil(String o);
    
    
}
