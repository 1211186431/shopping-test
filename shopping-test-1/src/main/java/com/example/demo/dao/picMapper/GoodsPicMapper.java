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
      @Insert("insert into goodsPic(goodsId,picture) value(#{goodsId},#{picture})")
      public int insertPic(GoodsPic g);
      
      @Select("select * from goodsPic where goodsId=#{goodsId}")
      public ArrayList<GoodsPic> getGoodsPic(int goodsId);
      
      @Delete("delete from goodsPic where id=#{id}")
      public void deleteGoodsPic(int id);
}
