package com.example.demo.dao.userMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.collection.Collection;

@Mapper
public interface UserCMapper extends BaseMapper<Collection>{
    @Select("select Coll.id,Coll.user_id,coll.goods_id,price,goods.`name`,createDate from Coll join goods on Coll.goods_id=goods.id where Coll.user_id=#{userId}")
    public ArrayList<Collection> getCollection(int userId);
    
    @Insert("insert into Coll(user_id,goods_id,createDate)"
    		+ " values(#{user_id},#{goods_id},#{createDate})")
    public void insertCollection(Collection c);
    
    @Select("select goods_id from coll where user_id= #{userId}")
    public ArrayList<Integer> getUserCollGoods(int userId);
    
    @Delete("delete from coll where id = #{id}")
    public void deleteCollGoods(int id);
}
