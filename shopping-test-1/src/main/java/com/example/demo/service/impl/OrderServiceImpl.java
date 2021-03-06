package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.OrderDetail;
import com.example.demo.bean.goods.OrderGoods;
import com.example.demo.bean.goods.OrderR;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.dao.goodsMapper.GoodsMapper;
import com.example.demo.dao.orderMapper.OrderMapper;
import com.example.demo.dao.userMapper.UserMapper;
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
//		UserInfo userInfo = this.uMapper.getUserInfo(o.getUserId());
//		BigDecimal newMoney = userInfo.getMoney().subtract(o.getAllprice());
//        this.uMapper.updateUserMoney(newMoney, userInfo.getId());
//		// 更新用户金额
		OrderUtil ou = new OrderUtil();
		OrderDetail orderD = ou.getOrderD(o);
		this.oMapper.insertOrder(orderD);  //插入订单
		for (int i = 0; i < o.getGoodsList().size(); i++) {
			int goodsId = o.getGoodsList().get(i).getGoodsId();
			int goodsNum = o.getGoodsList().get(i).getGoodsNum();
			Goods g = this.gMapper.getGoodsById(goodsId);
			int newInventory = g.getInventory() - goodsNum;
			int salesNum=g.getSalesNum()+goodsNum;
            this.gMapper.updateGoodsNum(newInventory, goodsId,salesNum);
			// 更新商品数量
            OrderGoods orderGoods=new OrderGoods();
            orderGoods.setGoodsId(goodsId);
            orderGoods.setGoodsNum(goodsNum);
            orderGoods.setOrderNumber(o.getOrderNumber());
            orderGoods.setState(0);
			this.oMapper.insertGoodsOrdet(orderGoods);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("o", orderGoods);
			quartz.task(new MyFirstJob(),map,orderGoods.getId()+"");
		}
		return orderD;
	}
	
	@Override
	public void updateOrder(int OrderId,int state) throws SchedulerException {
		// TODO Auto-generated method stub
		this.oMapper.upDateGoodsOrdet(OrderId,state);
	}

	@Override
	public OrderDetail getOrderByNum(String orderNum) {
		// TODO Auto-generated method stub
		OrderDetail od = this.oMapper.getOrderByNum(orderNum);
		return od;
	}

	@Override
	public ArrayList<OrderDetail> getUserOrder(int user_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderDetail> a = this.oMapper.getUserOrder(user_id);
		return a;
	}

	@Override
	public ArrayList<OrderGoods> getOrderGoods(String o) {
		// TODO Auto-generated method stub
		return this.oMapper.getGoodsUtil(o);
	}
	
	

}
