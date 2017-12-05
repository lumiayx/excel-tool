package com.yx.controller;


import com.yx.excel.util.DataUtil;
import com.yx.excel.util.ExcelImportUtil;
import com.yx.excel.util.PropertiesManager;
import com.yx.model.online.SCSJ;
import com.yx.model.ransom.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 赎楼台账处理类
 * Created by wb0006 on 2017/12/4.
 */
public class RansomController {

    public static List<SLTZDATA> readExcel(Object clas){
        if(clas instanceof GQT){
            return readGQT("过桥通");
        }else if (clas instanceof HBYW){
            return readHBYW("红本业务");
        }else if (clas instanceof EYT){
            return readEYT("E押通");
        }else if (clas instanceof CWD){
            return readCWD("车位贷");
        }else if (clas instanceof XHD){
            return readXHD("循环贷");
        }else if (clas instanceof KJD){
            return readKJD("空间贷");
        }else{
            System.out.println("无效SheetName");
            return null;
        }
    }
    public static List<SLTZDATA> readExcel(){

        List<SLTZDATA> scsj = new ArrayList<>();
        List<SLTZDATA> scsj2 = new ArrayList<>();
        scsj.addAll(readExcel(new GQT()));
        scsj.addAll(readExcel(new HBYW()));
        scsj.addAll(readExcel(new EYT()));
        scsj.addAll(readExcel(new CWD()));
        scsj.addAll(readExcel(new XHD()));
        scsj.addAll(readExcel(new KJD()));
        System.out.println("合计：" + scsj.size());
        return scsj;
    }

    private static List<SLTZDATA> readGQT(String sheetName){
        List<SLTZDATA> scsjList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(GQT.class, PropertiesManager.getInstance().getString("sltz"),sheetName);
        for(Object o : objList){
            GQT gqt = (GQT)o;
            SLTZDATA s = new SLTZDATA();
            s.setHtbh(gqt.getD() == null ? "" : gqt.getD());
            s.setName(gqt.getB() == null ? "" : gqt.getB());
            s.setCkmoney(DataUtil.changeMoney(gqt.getP()));
            s.setFkTime(DataUtil.changeDate(gqt.getZ()));
            s.setKhsfzh(gqt.getE() == null ? "" : gqt.getE());
            s.setProName(sheetName);
            s.setCurMoney("");
            //合同编号和客户姓名没有 不保存
            if(s.getName() == "" && s.getHtbh() == ""){
                continue;
            }
            scsjList.add(s);
        }
        System.out.println("过桥通：" + scsjList.size());
        return scsjList;
    }

    private static List<SLTZDATA> readHBYW(String sheetName){
        List<SLTZDATA> scsjList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(HBYW.class, PropertiesManager.getInstance().getString("sltz"),sheetName);
        for(Object o : objList){
            HBYW gqt = (HBYW)o;
            SLTZDATA s = new SLTZDATA();
            s.setName(gqt.getB() == null ? "" : gqt.getB());
            s.setHtbh(gqt.getD() == null ? "" : gqt.getD());
            s.setKhsfzh(gqt.getE() == null ? "" : gqt.getE());
            s.setCkmoney(DataUtil.changeMoney(gqt.getQ()));
            s.setFkTime(gqt.getS() == null ? "" : gqt.getS());
            s.setProName(sheetName);
            s.setCurMoney("");
            //合同编号和客户姓名没有 不保存
            if(s.getName() == "" && s.getHtbh() == ""){
                continue;
            }
            scsjList.add(s);
        }
        System.out.println("红本业务：" + scsjList.size());
        return scsjList;
    }

    private static List<SLTZDATA> readEYT(String sheetName){
        List<SLTZDATA> scsjList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(EYT.class, PropertiesManager.getInstance().getString("sltz"),sheetName);
        for(Object o : objList){
            EYT gqt = (EYT)o;
            SLTZDATA s = new SLTZDATA();
            s.setName(gqt.getB() == null ? "" : gqt.getB());
            s.setHtbh(gqt.getC() == null ? "" : gqt.getC());
            s.setKhsfzh(gqt.getD() == null ? "" : gqt.getD());
            s.setCkmoney(DataUtil.changeMoney(gqt.getP()));
            s.setFkTime(DataUtil.changeDate(gqt.getQ()));
            s.setProName(sheetName);
            s.setCurMoney(DataUtil.changeMoney(gqt.getEO()));
            //合同编号和客户姓名没有 不保存
            if(s.getName() == "" && s.getHtbh() == ""){
                continue;
            }
            scsjList.add(s);
        }
        System.out.println("E押通：" + scsjList.size());
        return scsjList;
    }

    private static List<SLTZDATA> readCWD(String sheetName){
        List<SLTZDATA> scsjList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(CWD.class, PropertiesManager.getInstance().getString("sltz"),sheetName);
        for(Object o : objList){
            CWD gqt = (CWD)o;
            SLTZDATA s = new SLTZDATA();
            s.setName(gqt.getB() == null ? "" : gqt.getB());
            s.setHtbh(gqt.getC() == null ? "" : gqt.getC());
            s.setKhsfzh(gqt.getD() == null ? "" : gqt.getD());
            s.setCkmoney(DataUtil.changeMoney(gqt.getP()));
            s.setFkTime(DataUtil.changeDate(gqt.getQ()));
            s.setProName(sheetName);
            s.setCurMoney(DataUtil.changeMoney(gqt.getCU()));
            //合同编号和客户姓名没有 不保存
            if(s.getName() == "" && s.getHtbh() == ""){
                continue;
            }
            scsjList.add(s);
        }
        System.out.println("车位贷：" + scsjList.size());
        return scsjList;
    }

    private static List<SLTZDATA> readXHD(String sheetName){
        List<SLTZDATA> scsjList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(XHD.class, PropertiesManager.getInstance().getString("sltz"),sheetName);
        for(Object o : objList){
            XHD gqt = (XHD)o;
            SLTZDATA s = new SLTZDATA();
            s.setName(gqt.getB() == null ? "" : gqt.getB());
            s.setHtbh(gqt.getD() == null ? "" : gqt.getD());
            s.setKhsfzh(gqt.getE() == null ? "" : gqt.getE());
            s.setCkmoney(DataUtil.changeMoney(gqt.getQ()));
            s.setFkTime(DataUtil.changeDate(gqt.getS()));
            s.setProName(sheetName);
            s.setCurMoney(DataUtil.changeMoney(gqt.getDW()));
            //合同编号和客户姓名没有 不保存
            if(s.getName() == "" && s.getHtbh() == ""){
                continue;
            }
            scsjList.add(s);
        }
        System.out.println("循环贷：" + scsjList.size());
        return scsjList;
    }

    private static List<SLTZDATA> readKJD(String sheetName){
        List<SLTZDATA> scsjList = new ArrayList<>();
        List<Object> objList = ExcelImportUtil.importExcel(KJD.class, PropertiesManager.getInstance().getString("sltz"),sheetName);
        for(Object o : objList){
            KJD gqt = (KJD)o;
            SLTZDATA s = new SLTZDATA();
            s.setName(gqt.getB() == null ? "" : gqt.getB());
            s.setHtbh(gqt.getC() == null ? "" : gqt.getC());
            s.setKhsfzh(gqt.getD() == null ? "" : gqt.getD());
            s.setCkmoney(DataUtil.changeMoney(gqt.getO()));
            s.setFkTime(DataUtil.changeDate(gqt.getQ()));
            s.setProName(sheetName);
            s.setCurMoney(DataUtil.changeMoney(gqt.getDM()));
            //合同编号和客户姓名没有 不保存
            if(s.getName() == "" && s.getHtbh() == ""){
                continue;
            }
            scsjList.add(s);
        }
        System.out.println("空间贷：" + scsjList.size());
        return scsjList;
    }



}
