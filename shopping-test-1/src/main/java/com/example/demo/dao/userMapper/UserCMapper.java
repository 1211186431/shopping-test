package com.example.demo.dao.userMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.collection.Collection;

@Mapper
public interface UserCMapper extends BaseMapper<Collection>{
	/**
	 * 按照用户id获取收藏
	 * @param userId
	 * @return
	 */
    @Select("select Coll.id,Coll.user_id,coll.goods_id,price,goods.`name`,createDate,goods.picture from Coll join goods on Coll.goods_id=goods.id where Coll.user_id=#{userId}")
    public ArrayList<Collection> getCollection(int userId);
    
    /**
     * 插入收藏表
     * @param c
     */
    @Insert("insert into Coll(user_id,goods_id,createDate)"
    		+ " values(#{user_id},#{goods_id},#{createDate})")
    @SelectKey(statement ="select last_insert_id()",keyProperty="id",before=false,resultType=int.class)
    public void insertCollection(Collection c);
    
    /**
     * 获取用户的收藏
     * @param userId
     * @return
     */
    @Select("select goods_id from coll where user_id= #{userId}")
    public ArrayList<Integer> getUserCollGoods(int userId);
    
    /**
     * 删除收藏
     * @param id
     */
    @Delete("delete from coll where id = #{id}")
    public void deleteCollGoods(int id);
}
