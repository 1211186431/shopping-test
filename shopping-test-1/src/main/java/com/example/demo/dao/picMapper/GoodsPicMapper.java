package com.example.demo.dao.picMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.goods.GoodsPic;

@Mapper
public interface GoodsPicMapper extends BaseMapper<GoodsPic>{
	/**
	 * 插入商品的图片，图片表
	 * @param g
	 * @return
	 */
      @Insert("insert into goodsPic(goodsId,picture) value(#{goodsId},#{picture})")
      public int insertPic(GoodsPic g);
      
      /**
       * 获取商品的所有照片
       * @param goodsId
       * @return
       */
      @Select("select * from goodsPic where goodsId=#{goodsId}")
      public ArrayList<GoodsPic> getGoodsPic(int goodsId);
      
      /**
       * 删除照片
       * @param id
       */
      @Delete("delete from goodsPic where id=#{id}")
      public void deleteGoodsPic(int id);
      
      @Select("select picture from goodsPic where id=#{id}")
      public String getPicPath(int id);
}
