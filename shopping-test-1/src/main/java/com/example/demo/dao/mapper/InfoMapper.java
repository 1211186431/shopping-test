package com.example.demo.dao.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.ShoppingInfo;


@Mapper
public interface InfoMapper extends BaseMapper<ShoppingInfo>{
    @Select("select * from shopping1")
	public List<ShoppingInfo> getInfo();
    
    @Select("select * from shopping1 where id = #{id}")
    public ShoppingInfo getOne(int id);
    
    @Insert("insert into shopping1(name,price,other)"
    		+" values(#{name},#{price},#{other})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public Long insertOne(ShoppingInfo shoppingInfo); 
    
    @Update("update shopping1 set price=#{price}, other=#{other},name=#{name} where id=#{id}")
	public void updateInfo(ShoppingInfo shoppingInfo);
	
	@Delete("delete from shopping1 where id = #{id}")
	public void delete(int id);
     
}
