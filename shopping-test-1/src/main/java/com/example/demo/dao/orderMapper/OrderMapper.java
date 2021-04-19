package com.example.demo.dao.orderMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.helper.GoodsUtil;

@Mapper
public interface OrderMapper extends BaseMapper<OrderDetail>{
    @Insert("insert into Myorder(orderNumber,user_id,Allprice,purchasingDate,receiver,state,payment)"
    		+ " values(#{orderNumber},#{user_id},#{Allprice},#{purchasingDate},#{receiver},#{state},#{payment}) ")
    public int insertOrder(OrderDetail o);
    
    @Update("update Myorder set state=#{state} where orderNumber=#{orderNumber}")
    public void updateOrder(String orderNumber,int state);
    
    @Select("select * from Myorder where orderNumber=#{orderNumber}")
    public OrderDetail getOrderByNum(String orderNumber);
    
    @Select("select * from Myorder where user_id=#{user_id}")
    public ArrayList<OrderDetail> getUserOrder(int user_id);
    
    @Insert("insert into goods_order(orderNumber,goodsId,goodsNum) "
    		+ "values(#{o},#{goodsId},#{num})")
    public void insertGoodsOrdet(String o,int goodsId,int num);
    
    @Select("select goodsId,goodsNum from goods_order where orderNumber=#{o}")
    public ArrayList<GoodsUtil> getGoodsUtil(String o);
}
