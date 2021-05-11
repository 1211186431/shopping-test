package com.example.demo.orderJob;


import java.math.BigDecimal;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.OrderR;
import com.example.demo.bean.user.UserInfo;
import com.example.demo.dao.goodsMapper.GoodsMapper;
import com.example.demo.dao.orderMapper.OrderMapper;
import com.example.demo.dao.userMapper.UserMapper;
import com.example.demo.helper.ApplicationContextUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyFirstJob extends QuartzJobBean{
	OrderR o;
   
	public OrderR getO() {
		return o;
	}

	public void setO(OrderR o) {
		this.o = o;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		OrderMapper oMapper=(OrderMapper) ApplicationContextUtil.getApplicationContext().getBean(OrderMapper.class);
		GoodsMapper gMapper=(GoodsMapper) ApplicationContextUtil.getApplicationContext().getBean(GoodsMapper.class);
		UserMapper uMapper=(UserMapper) ApplicationContextUtil.getApplicationContext().getBean(UserMapper.class);
		for (int i = 0; i < o.getGoodsList().size(); i++) {
			int goodsId = o.getGoodsList().get(i).getGoodsId();
			int goodsNum = o.getGoodsList().get(i).getGoodsNum();
			Goods g = gMapper.getGoodsById(goodsId);
			int sellerId = g.getUser_id();
			UserInfo sellerInfo =uMapper.getUserInfo(sellerId);
			BigDecimal number = new BigDecimal(goodsNum);
			number = BigDecimal.valueOf((int) goodsNum);
			BigDecimal goodsMoney = g.getPrice().multiply(number);
			BigDecimal sellerMoney=sellerInfo.getMoney().add(goodsMoney);
			uMapper.updateUserMoney(sellerMoney, sellerInfo.getId());
			//更新商家金额
			oMapper.upDateGoodsOrdet(o.getOrderNumber(),1); //更新订单状态测试
			
		}
		log.info("任务完成");
	}
}
