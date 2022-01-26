package com.sdu.demo.service;


import com.sdu.demo.entity.DailyTakein;
import org.apache.ibatis.annotations.Param;
import org.python.antlr.ast.Str;

import java.util.List;

public interface DailyTakeinService {

    public int insertByUsernameAndFood(String userName,String food,String date);

    public List<Double> calculateTakein(String userName,String date);

    public List<DailyTakein> getFavorableTaste(String userName,String date);

    public void recognizeByPhoto();
}
