package com.example.demo.dao.goodsMapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.Goods;
import com.example.demo.bean.goods.GoodsShow;
import com.example.demo.bean.goods.GoodsType;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods>{
	/**
	 * 获取所有的上架商品
	 * @return
	 */
    @Select("select * from goods where state=1")  
	public ArrayList<Goods> getAllGoods();
    
    /**
     * 获取所有的审核商品
     * @return
     */
    @Select("select * from goods where state=0") 
    public ArrayList<Goods> getOffGoods();
    
    /**
     * 更新商品状态
     * @param state 商品状态
     * @param id 商品id
     */
    @Update("update goods set state=#{state}"
    		+ " where id=#{id}")
    public void upDateGoodsState(int state,int id);
    
    /**
     * 获取所有商品的展示信息
     * @return
     */
    @Select("select id,name,price,picture,user_id from goods where state=1") 
    public ArrayList<GoodsShow> getGoodsShow();
    
    /**
     * 按照名字模糊搜索商品
     * @param name
     * @return
     */
    @Select("select id,name,price,picture from goods where state=1 && name like CONCAT('%',#{name},'%')") 
    public ArrayList<GoodsShow> getGoodsShowByName(String name);
    
    /**
     * 按照类别模糊搜索商品
     * @param name
     * @return
     */
    //@Select("SELECT g.id,g.price,g.name,g.picture,g.user_id FROM type t JOIN goodstype gt ON t.id=gt.type_id JOIN goods g ON gt.goods_id=g.id WHERE gt.type_id=#{type}") 
    @SelectProvider(type = GoodsSelect.class, method = "getGoodsShow")
    public ArrayList<GoodsShow> getGoodsShowByType(@Param("type")int type,@Param("name")String name,@Param("priceSort")String priceSort
    		,@Param("salesSort")String salesSort,@Param("gradeSort")String gradeSort);
    
    /**
     * 获取指定商品id
     * @param goodsId 商品id
     * @return
     */
    @Select("select * from goods where id=#{goodsId}")
    public Goods getGoodsById(int goodsId);
     
    /**
     * 更新商品库存
     * @param num
     * @param goodsId
     * @return
     */
    @Update("update goods set inventory=#{num},salesNum=#{salesNum} where id=#{goodsId}")
    public int updateGoodsNum(int num,int goodsId,int salesNum);
    
    /**
     * 插入商品信息
     * @param g
     * @return
     */
    @Insert("insert into goods(user_id,price,inventory,oldAndnew,state,name,details,"
    		+ "onsaleDate,picture,bargain,delivery) values(#{user_id},#{price},#{inventory},#{oldAndnew},#{state},"
    		+ "#{name},#{details},#{onsaleDate},#{picture},#{bargain},#{delivery})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public int insertGoods(Goods g);
    
    /**
     * 更新商品信息
     * @param g
     */
    @Update("update goods set user_id=#{user_id},price=#{price},inventory=#{inventory},oldAndnew=#{oldAndnew},state=#{state},"
    		+ "name=#{name},details=#{details},onsaleDate=#{onsaleDate},picture=#{picture},bargain=#{bargain},delivery=#{delivery}"
    		+ " where id=#{id}")
    public void upDateGoods(Goods g);
    
    /**
     * 更新商品图片
     * @param pic
     * @param goodsId
     */
    @Update("update goods set picture=#{pic} where id=#{goodsId}")
    public void upDateGoodsPic(String pic,int goodsId);
    
    /**
     * 获取指定商品的类别
     * @param goodsId
     * @return
     */
    @Select("SELECT type_id,type FROM goodsType JOIN type ON goodsType.type_id = type.id WHERE goods_id =#{goodsId}")
    public ArrayList<GoodsType> getGoodsType(int goodsId);
    
    /**
     * 设置商品类别
     * @param typeId
     * @param goodsId
     */
    @Insert("insert into goodstype(type_id,goods_id) values(#{typeId},#{goodsId})")
    public void insertGoodsType(int typeId,int goodsId);
   
    /**
     * 删除指定商品的列表
     * @param goodsId
     */
    @Delete("delete from goodstype where goods_id = #{goodsId}")
    public void deleteGoodsType(int goodsId);
    
    /**
     * 获取所有的类别种类
     * @return
     */
    @Results(id="typeMap", value={
			@Result(property="type_id", column="id")
		})
    @Select("select * from type")
    public ArrayList<GoodsType> getAllGoodsType();
    
    /**
     * 获取指定商家的所有商品
     * @param sellerId
     * @return
     */
    @Select("select * from goods where user_id=#{sellerId}")
    public ArrayList<Goods> getGoodsBySeller(int sellerId);
    
}
