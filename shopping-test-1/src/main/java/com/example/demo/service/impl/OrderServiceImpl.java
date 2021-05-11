package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderR;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.dao.goodsMapper.GoodsMapper;
import com.example.demo.dao.orderMapper.OrderMapper;
import com.example.demo.dao.userMapper.UserMapper;
import com.example.demo.helper.GoodsUtil;
import com.example.demo.helper.OrderUtil;
import com.example.demo.orderJob.MyFirstJob;
import com.example.demo.orderJob.QuartzConfig;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderMapper oMapper;

	@Autowired
	GoodsMapper gMapper;

	@Autowired
	UserMapper uMapper;
	
	@Autowired
	QuartzConfig quartz;

	@Override
	public OrderDetail insertOrder(OrderR o) throws SchedulerException {
		// TODO Auto-generated method stub
		UserInfo userInfo = this.uMapper.getUserInfo(o.getUserId());
		BigDecimal newMoney = userInfo.getMoney().subtract(o.getAllprice());
        this.uMapper.updateUserMoney(newMoney, userInfo.getId());
		// 更新用户金额
		OrderUtil ou = new OrderUtil();
		OrderDetail orderD = ou.getOrderD(o);
		this.oMapper.insertOrder(orderD);  //插入订单
		for (int i = 0; i < o.getGoodsList().size(); i++) {
			int goodsId = o.getGoodsList().get(i).getGoodsId();
			int goodsNum = o.getGoodsList().get(i).getGoodsNum();
			Goods g = this.gMapper.getGoodsById(goodsId);
			int newInventory = g.getInventory() - goodsNum;
            this.gMapper.updateGoodsNum(newInventory, goodsId);
			// 更新商品数量
//			int sellerId = g.getUser_id();
//			UserInfo sellerInfo = this.uMapper.getUserInfo(sellerId);
//			BigDecimal number = new BigDecimal(goodsNum);
//			number = BigDecimal.valueOf((int) goodsNum);
//			BigDecimal goodsMoney = g.getPrice().multiply(number);
//			BigDecimal sellerMoney=sellerInfo.getMoney().add(goodsMoney);
//			this.uMapper.updateUserMoney(sellerMoney, sellerInfo.getId());
			//更新商家金额
			this.oMapper.insertGoodsOrdet(o.getOrderNumber(), goodsId, goodsNum,0);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("o", o);
		quartz.task(new MyFirstJob(),map,o.getOrderNumber());
		return null;
	}

	@Override
	public void updateOrder(String o, int state) {
		// TODO Auto-generated method stub
		this.oMapper.updateOrder(o, state);
	}

	@Override
	public OrderR getOrderByNum(String orderNum) {
		// TODO Auto-generated method stub
		OrderDetail od = this.oMapper.getOrderByNum(orderNum);
		ArrayList<GoodsUtil> a = this.oMapper.getGoodsUtil(orderNum);
		OrderUtil ou = new OrderUtil();
		return ou.getOrderR(od, a);
	}

	@Override
	public ArrayList<OrderR> getUserOrder(int user_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderDetail> a = this.oMapper.getUserOrder(user_id);
		ArrayList<OrderR> or = new ArrayList<OrderR>();
		OrderUtil ou = new OrderUtil();
		for (int i = 0; i < a.size(); i++) {
			OrderDetail o = a.get(i);
			ArrayList<GoodsUtil> g = this.oMapper.getGoodsUtil(o.getOrderNumber());
			or.add(ou.getOrderR(o, g));
		}
		return or;
	}

}
