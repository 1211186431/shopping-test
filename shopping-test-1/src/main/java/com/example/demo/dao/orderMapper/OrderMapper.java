package com.example.demo.dao.orderMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.helper.GoodsUtil;

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
    
    /**
     * 设置订单中商品和数量
     * @param o
     * @param goodsId
     * @param num
     */
    @Insert("insert into goods_order(orderNumber,goodsId,goodsNum,state) "
    		+ "values(#{o},#{goodsId},#{num},#{state})")
    public void insertGoodsOrdet(String o,int goodsId,int num,int state);
    
    
    @Update("update goods_order set state=#{state} where orderNumber=#{o}")
    public void upDateGoodsOrdet(String o,int state);
    
    /**
     * 订单信息辅助
     * @param o
     * @return
     */
    @Select("select goodsId,goodsNum,state from goods_order where orderNumber=#{o}")
    public ArrayList<GoodsUtil> getGoodsUtil(String o);
}
