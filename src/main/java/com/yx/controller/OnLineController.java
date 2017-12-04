package com.yx.controller;

import com.yx.excel.util.ExcelImportUtil;
import com.yx.excel.util.PropertiesManager;
import com.yx.model.online.SCSJ;
import com.yx.model.ransom.SLTZDATA;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产系统数据处理类
 * Created by wb0006 on 2017/12/4.
 */

public class OnLineController {
    private static String file;

    private static String name;

    static  {
        PropertiesManager pm = PropertiesManager.getInstance();
        file = pm.getString("scsj.file");
        name = pm.getString("scsj.sheetName");
    }

    public static List<SLTZDATA> readExcel(){
        List<SLTZDATA> sltzList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(SCSJ.class, file,name);
        for(Object o : objList){
            SCSJ scsj =  (SCSJ)o;
            SLTZDATA s = new SLTZDATA();
            s.setHtbh(scsj.getHth() == null ? "" : scsj.getHth());
            s.setName(scsj.getKhName() == null ? "" : scsj.getKhName());
            s.setCkmoney(scsj.getHtmoney() == null ? "" : scsj.getHtmoney());
            s.setFkTime(scsj.getFkTime() == null ? "" : scsj.getFkTime());
            s.setKhsfzh(scsj.getZjh() == null ? "" : scsj.getZjh());
            s.setProName(scsj.getProName() == null ? "" : scsj.getProName());
            s.setCurMoney("");
            sltzList.add(s);
        }
        System.out.println("生产数据：" + sltzList.size());
        return sltzList;
    }
}
