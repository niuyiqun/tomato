package com.sdu.demo.mapping;


import com.sdu.demo.entity.Memorandum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Mapper
public interface MemorandumMapper {




//    //根据用户名返回所有备忘录的所有信息
//    @Select("SELECT * FROM memorandum WHERE userName = #{userName}")
//    Memorandum findByUserName(@Param("userName") String userName);


    //查询用户的菜品
//    @Select("SELECT foodList FROM memorandum WHERE userName = #{userName}")
//    public String selectFoodlistByUsername(String userName);

    //删除某种菜的操作逻辑

    //用户添加菜品到备忘录
    @Insert("INSERT INTO memorandum(userName,food,time) VALUES(#{userName},#{food},#{time})")
    int addFoodToMemorandumByUsername(@Param("userName") String userName,@Param("food") String food,
                                      @Param("time") String time);


    //搜索用户备忘录的全部食品的各种信息
    @Select("SELECT * FROM memorandum WHERE userName = #{userName}")
    List<Memorandum> selectMemorandumByUsername(@Param("userName") String userName);

    @Delete("DELETE FROM memorandum WHERE userName=#{userName} and food=#{food}")
    int deleteFromMemorandumByUsernameAndFood(@Param("userName") String userName,@Param("food") String food);



}
