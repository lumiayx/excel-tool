package com.yx.controller;

import com.yx.model.ransom.SLTZDATA;
import com.yx.model.ransom.SLTZDATACOMMON;

import java.util.*;

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
    public static Map<String, List<SLTZDATA>> equalResult(List<SLTZDATA> compareList, List<SLTZDATA> toCompareList, int[] compareFileArr,  int[] vaildFileArr) {

        Map<String, List<SLTZDATA>> map = new HashMap<>();
        List<SLTZDATA> resultList = new ArrayList<>();
        List<SLTZDATA> aCommonList = new ArrayList<>();
        List<SLTZDATA> aDiffList = new ArrayList<>();
        List<SLTZDATA> toACommonList = new ArrayList<>();
        List<SLTZDATA> toADiffList = new ArrayList<>();
        for (SLTZDATA a : compareList) {
            boolean flag = false;
            for (SLTZDATA b : toCompareList) {
                if (compareObj(a, b, compareFileArr,vaildFileArr)) {
                    flag = true;
                    aCommonList.add(a);
                }
            }
        }


        for (SLTZDATA a : toCompareList) {
            boolean flag = false;
            for (SLTZDATA b : compareList) {
                if (compareObj(a, b, compareFileArr,vaildFileArr)) {
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

        map.put("onlineDiff", filterList(aDiffList));
        map.put("ransomDiff", filterList(toADiffList));
        map.put("onlineCommon", filterList(aCommonList));
        map.put("ransomCommon", filterList(toACommonList));
        return map;
    }

    private static List<SLTZDATA> filterList(List<SLTZDATA> list){
        Set<SLTZDATA> set = new HashSet<>();
        set.addAll(list);

        return new ArrayList<SLTZDATA>(set);

    }
    private static boolean compareObj(SLTZDATA a, SLTZDATA b, int[] compareFileArr,  int[] vaildFileArr) {

        //默认完全匹配
        boolean flag = true;
        if (vaildFileArr[0] == 1 && compareFileArr[0] == 1) {
            if (!a.getName().equals(b.getName())) {
                return false;
            }
        }
        if (vaildFileArr[1] == 1 && compareFileArr[1] == 1) {
            if (!a.getHtbh().equals(b.getHtbh())) {
                return false;
            }
        }
        if (vaildFileArr[2] == 1 && compareFileArr[2] == 1) {
            if (!a.getKhsfzh().equals(b.getKhsfzh())) {
                return false;
            }
        }
        if (vaildFileArr[3] == 1 && compareFileArr[3] == 1) {
            if (!a.getCkmoney().equals(b.getCkmoney())) {
                return false;
            }
        }
        if (vaildFileArr[4] == 1 && compareFileArr[4] == 1) {
            if (!a.getProName().equals(b.getProName())) {
                return false;
            }
        }
        if (vaildFileArr[5] == 1 && compareFileArr[5] == 1) {
            if (!a.getFkTime().equals(b.getFkTime())) {
                return false;
            }
        }
        if (vaildFileArr[6] == 1 && compareFileArr[6] == 1) {
            if (!a.getCurMoney().equals(b.getCurMoney())) {
                return false;
            }
        }
        return flag;
    }

    public static List<SLTZDATACOMMON> diffResult(List<SLTZDATA> compareList, List<SLTZDATA> toCompareList, int[] compareFileArr, int[] vaildFileArr) {
        int[] diffArr = changeArr(compareFileArr);
        List<SLTZDATACOMMON> resultList = new ArrayList<>();
        for (SLTZDATA a : compareList) {
            for (SLTZDATA b : toCompareList) {
                if (compareObj(a, b, compareFileArr, vaildFileArr) && !compareObj(a, b, diffArr,vaildFileArr)) {
                    SLTZDATACOMMON comm = new SLTZDATACOMMON();
                    comm.setDiff(valueArr(compareFileArr));
                    comm.setSplit("|");
                    comm.setName(a.getName());
                    comm.setHtbh(a.getHtbh());
                    comm.setKhsfzh(a.getKhsfzh());
                    comm.setCkmoney(a.getCkmoney());
                    comm.setProName(a.getProName());
                    comm.setFkTime(a.getFkTime());
                    comm.setCurMoney(a.getCurMoney());
                    comm.setName2(b.getName());
                    comm.setHtbh2(b.getHtbh());
                    comm.setKhsfzh2(b.getKhsfzh());
                    comm.setCkmoney2(b.getCkmoney());
                    comm.setProName2(b.getProName());
                    comm.setFkTime2(b.getFkTime());
                    comm.setCurMoney2(b.getCurMoney());
                    resultList.add(comm);
                }
            }
        }
        return resultList;
    }

    private static int[] changeArr(int[] compareFileArr){
        int[] copyArr = new int[compareFileArr.length];
        for(int i = 0; i < compareFileArr.length; i ++){
            copyArr[i] = compareFileArr[i] == 1 ? 0 : 1;
        }
        return copyArr;
    }

    private static String valueArr(int[] compareFileArr){
        StringBuilder sb = new StringBuilder();
        sb.append(compareFileArr[0] == 1 ? "客户名 " : "");
        sb.append(compareFileArr[1] == 1 ? "合同编号" : "");
        sb.append(compareFileArr[2] == 1 ? "客户身份证件" : "");
        sb.append(compareFileArr[3] == 1 ? "出款金额" : "");
        sb.append(compareFileArr[4] == 1 ? "产品名" : "");
        sb.append(compareFileArr[5] == 1 ? "放款日期" : "");
        sb.append(compareFileArr[6] == 1 ? "利息金额" : "");
        return sb.toString();
    }
}
