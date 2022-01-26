package com.sdu.demo.service;

import com.sdu.demo.entity.Memorandum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemorandumService {

    public int addFoodToMemorandumByUsername(String userName,String food,String time);
    public List<Memorandum> selectMemorandumByUsername(String userName);
    public int deleteFromMemorandumByUsernameAndFood(String userName,String food);

}
