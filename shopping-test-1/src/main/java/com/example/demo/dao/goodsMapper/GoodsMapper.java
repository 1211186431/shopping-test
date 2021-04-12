package com.example.demo.dao.goodsMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsShow;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods>{
    @Select("select * from goods where state=1")  
	public ArrayList<Goods> getAllGoods();
    
    @Select("select id,name,price,picture from goods where state=1") 
    public ArrayList<GoodsShow> getGoodsShow();
    
    @Select("select * from goods where id=#{goodsId}")
    public Goods getGoodsById(int goodsId);
}
