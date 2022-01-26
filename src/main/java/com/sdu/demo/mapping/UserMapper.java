package com.sdu.demo.mapping;

import com.github.pagehelper.Page;
import com.sdu.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


//select insert update delete
@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")     //
    User findById(@Param("id") int id);

    @Select("SELECT password FROM user WHERE userName=#{userName}")
    String loginViaUserNameAndPassword(User user);

    @Insert({"INSERT INTO user(userName,password,phoneNumber) VALUES(#{userName},#{password},#{phoneNumber})"})
    int register(User user);     //可以自动绑定实体类

    @Select("SELECT * FROM user WHERE userName = #{userName}")
    User findByName(@Param("userName") String userName);

    @Update("UPDATE user SET height=#{height},weight=#{weight},sex=#{sex},age=#{age} WHERE userName=#{userName}")
    int updateBasicInfo(@Param("height") double height,@Param("weight") double weight,
                        @Param("sex") String sex,@Param("age") int age,@Param("userName") String userName);

    @Select("SELECT sex FROM user WHERE userName=#{userName}")
    String getSexByuserName(@Param("userName") String userName);

}
