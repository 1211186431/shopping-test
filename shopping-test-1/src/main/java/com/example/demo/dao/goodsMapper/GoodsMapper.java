package com.example.demo.dao.goodsMapper;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
    
    @Select("select * from goods where state=0") 
    public ArrayList<Goods> getOffGoods();
    
    @Update("update goods set state=#{state}"
    		+ " where id=#{id}")
    public void upDateGoodsState(int state,int id);
    
    @Select("select id,name,price,picture from goods where state=1") 
    public ArrayList<GoodsShow> getGoodsShow();
    
    @Select("select id,name,price,picture from goods where state=1 && name like CONCAT('%',#{name},'%')") 
    public ArrayList<GoodsShow> getGoodsShowByName(String name);
    
    @Select("select * from goods where id=#{goodsId}")
    public Goods getGoodsById(int goodsId);
    
    @Update("update goods set inventory=#{num} where id=#{goodsId}")
    public int updateGoodsNum(int num,int goodsId);
    
    @Insert("insert into goods(user_id,price,inventory,oldAndnew,state,name,details,"
    		+ "onsaleDate,picture,bargain,delivery) values(#{user_id},#{price},#{inventory},#{oldAndnew},#{state},"
    		+ "#{name},#{details},#{onsaleDate},#{picture},#{bargain},#{delivery})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public int insertGoods(Goods g);
    
    @Update("update goods set user_id=#{user_id},price=#{price},inventory=#{inventory},oldAndnew=#{oldAndnew},state=#{state},"
    		+ "name=#{name},details=#{details},onsaleDate=#{onsaleDate},picture=#{picture},bargain=#{bargain},delivery=#{delivery}"
    		+ " where id=#{id}")
    public void upDateGoods(Goods g);
    
    @Update("update goods set picture=#{pic} where id=#{goodsId}")
    public void upDateGoodsPic(String pic,int goodsId);
    
    @Select("SELECT type_id,type FROM goodsType JOIN type ON goodsType.type_id = type.id WHERE goods_id =#{goodsId}")
    public ArrayList<GoodsType> getGoodsType(int goodsId);
    
    @Insert("insert into goodstype(type_id,goods_id) values(#{typeId},#{goodsId})")
    public void insertGoodsType(int typeId,int goodsId);
   
    @Delete("delete from goodstype where goods_id = #{goodsId}")
    public void deleteGoodsType(int goodsId);
    
    @Results(id="typeMap", value={
			@Result(property="type_id", column="id")
		})
    @Select("select * from type")
    public ArrayList<GoodsType> getAllGoodsType();
    
    @Select("select * from goods where user_id=#{sellerId}")
    public ArrayList<Goods> getGoodsBySeller(int sellerId);
}
