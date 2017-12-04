package com.yx.controller;

import com.yx.model.ransom.SLTZDATA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对比处理
 * Created by wb0006 on 2017/12/4.
 */
public class ResultController {
    /**
     * @param compare
     * @param toCompare
     * @param compareFileArr 对应生产数据的7个字段 0  不比较  1 比较
     * @return
     */
    public static Map<String, List<SLTZDATA>> equalResult(List<SLTZDATA> compareList, List<SLTZDATA> toCompareList, int[] compareFileArr) {

        Map<String, List<SLTZDATA>> map = new HashMap<>();

        //TODO  数据过滤排序  还有导出sql没处理
        List<SLTZDATA> resultList = new ArrayList<>();

        List<SLTZDATA> aCommonList = new ArrayList<>();
        List<SLTZDATA> aDiffList = new ArrayList<>();
        List<SLTZDATA> toACommonList = new ArrayList<>();
        List<SLTZDATA> toADiffList = new ArrayList<>();
        for (SLTZDATA a : compareList) {
            boolean flag = false;
            for (SLTZDATA b : toCompareList) {
                if (compareObj(a, b, compareFileArr)) {
                    flag = true;
                    aCommonList.add(a);
                }
            }
        }


        for (SLTZDATA a : toCompareList) {
            boolean flag = false;
            for (SLTZDATA b : compareList) {
                if (compareObj(a, b, compareFileArr)) {
                    flag = true;
                    toACommonList.add(a);
                }
            }
        }

        for (SLTZDATA a : compareList) {
            if (!aCommonList.contains(a)) {
                aDiffList.add(a);
            }
        }

        for (SLTZDATA a : toCompareList) {
            if (!toACommonList.contains(a)) {
                toADiffList.add(a);
            }
        }

        map.put("a", aDiffList);
        map.put("b", toADiffList);
        map.put("ab", aCommonList.size() > toACommonList.size() ? aCommonList : toACommonList);
        return map;
    }

    private static boolean compareObj(SLTZDATA a, SLTZDATA b, int[] compareFileArr) {

        //默认完全匹配
        boolean flag = true;
        if (compareFileArr[0] == 1) {
            if (!a.getName().equals(b.getName())) {
                return false;
            }
        }
        if (compareFileArr[1] == 1) {
            if (!a.getHtbh().equals(b.getHtbh())) {
                return false;
            }
        }
        if (compareFileArr[2] == 1) {
            if (!a.getKhsfzh().equals(b.getKhsfzh())) {
                return false;
            }
        }
        if (compareFileArr[3] == 1) {
            if (!a.getCkmoney().equals(b.getCkmoney())) {
                return false;
            }
        }
        if (compareFileArr[4] == 1) {
            if (!a.getProName().equals(b.getProName())) {
                return false;
            }
        }
        if (compareFileArr[5] == 1) {
            if (!a.getFkTime().equals(b.getFkTime())) {
                return false;
            }
        }
        if (compareFileArr[6] == 1) {
            if (!a.getCurMoney().equals(b.getCurMoney())) {
                return false;
            }
        }
    }
}
