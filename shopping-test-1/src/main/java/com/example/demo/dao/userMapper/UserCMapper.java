package com.example.demo.dao.userMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.collection.Collection;

@Mapper
public interface UserCMapper extends BaseMapper<Collection>{
    @Select("select * from Coll where userId=#{userId}")
    public ArrayList<Collection> getCollection(int userId);
    
    @Insert("insert into Coll(user_id,goods_id,createDate)"
    		+ " values(#{user_id},#{goods_id},#{createDate})")
    public void insertCollection(Collection c);
}
