package com.yx.controller;

import com.yx.model.ransom.SLTZDATA;

import java.util.ArrayList;
import java.util.List;

/**
 * 对比处理
 * Created by wb0006 on 2017/12/4.
 */
public class ResultController {
    /**
     *
     * @param compare
     * @param toCompare
     * @param compareFileArr  对应生产数据的7个字段 0  不比较  1 比较
     * @return
     */
    public static List<SLTZDATA> equalResult(List<SLTZDATA> compareList, List<SLTZDATA> toCompareList, int[] compareFileArr){
        //TODO  数据过滤排序  还有导出sql没处理
        List<SLTZDATA> resultList = new ArrayList<>();
        for(SLTZDATA a : compareList){
            boolean flag = false;
            for(SLTZDATA b : toCompareList){
                if(compareFileArr[0] == 1){
                    flag = a.getHtbh().equals(b.getHtbh());
                    if(flag)    break;
                }
                if(compareFileArr[1] == 1){

                }
                if(compareFileArr[2] == 1){

                }
                if(compareFileArr[3] == 1){

                }
                if(compareFileArr[4] == 1){

                }
                if(compareFileArr[5] == 1){

                }
                if(compareFileArr[6] == 1){

                }
            }
        }
        return resultList;
    }
}
