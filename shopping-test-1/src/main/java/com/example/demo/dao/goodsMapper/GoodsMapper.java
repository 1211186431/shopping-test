package com.example.demo.dao.goodsMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsShow;
import com.example.demo.bean.goods.GoodsType;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods>{
    @Select("select * from goods where state=1")  
	public ArrayList<Goods> getAllGoods();
    
    @Select("select id,name,price,picture from goods where state=1") 
    public ArrayList<GoodsShow> getGoodsShow();
    
    @Select("select * from goods where id=#{goodsId}")
    public Goods getGoodsById(int goodsId);
    
    @Insert("insert into goods(user_id,price,inventory,oldAndnew,state,name,details,"
    		+ "onsaleDate,picture,bargain,delivery) values(#{user_id},#{price},#{inventory},#{oldAndnew},#{state},"
    		+ "#{name},#{details},#{onsaleDate},#{picture},#{bargain},#{delivery})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public int insertGoods(Goods g);
    
    @Update("update goods set user_id=#{user_id},price=#{price},inventory=#{inventory},oldAndnew=#{oldAndnew},state=#{state},"
    		+ "name=#{name},details=#{details},onsaleDate=#{onsaleDate},picture=#{picture},bargain=#{bargain},delivery=#{delivery}"
    		+ " where id=#{id}")
    public void upDateGoods(Goods g);
    
    @Select("SELECT type_id,type FROM goodsType JOIN type ON goodsType.type_id = type.id WHERE goods_id =#{goodsId}")
    public ArrayList<GoodsType> getGoodsType(int goodsId);
    
    @Insert("insert into goodstype(type_id,goods_id) values(#{typeId},#{goodsId})")
    public void insertGoodsType(int typeId,int goodsId);
   
    @Delete("delete from goodstype where goods_id = #{goodsId}")
    public void deleteGoodsType(int goodsId);
}
