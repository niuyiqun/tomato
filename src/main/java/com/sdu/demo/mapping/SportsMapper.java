package com.sdu.demo.mapping;

import com.sdu.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface SportsMapper {


    //前端上传今日步数
    @Insert({"INSERT INTO sports(userName,dailySteps,date) VALUES(#{userName},#{dailySteps},#{date})"})
    int addByUsername(@Param("userName") String userName,@Param("dailySteps") int dailySteps,@Param("date") String date);

    @Select("SELECT dailySteps FROM sports WHERE userName = #{userName} AND date = #{date}")
    int getdailySteps(@Param("userName") String userName,@Param("date") String date);
}
