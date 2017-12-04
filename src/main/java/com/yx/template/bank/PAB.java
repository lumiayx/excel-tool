package com.yx.template.bank;

import com.yx.excel.annotation.ExcelField;
import com.yx.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 平安银行
 * Created by wb0006 on 2017/12/4.
 */
@ExcelSheet(name = "history", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class PAB {
    @ExcelField(name = "交易日期")
    private String date;

    @ExcelField(name = "账号")
    private String zh;

    @ExcelField(name = "借")
    private String jie;

    @ExcelField(name = "贷")
    private String dai;

    @ExcelField(name = "对方账户")
    private String dfzh;

    @ExcelField(name = "对方账户名称")
    private String dfzhName;

    @ExcelField(name = "交易流水号")
    private String jylsh;

    @ExcelField(name = "摘要")
    private String zy;

    @ExcelField(name = "用途")
    private String yt;

    public PAB() {
    }

    public PAB(String date, String zh, String jie, String dai, String dfzh, String dfzhName, String jylsh, String zy, String yt) {
        this.date = date;
        this.zh = zh;
        this.jie = jie;
        this.dai = dai;
        this.dfzh = dfzh;
        this.dfzhName = dfzhName;
        this.jylsh = jylsh;
        this.zy = zy;
        this.yt = yt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getJie() {
        return jie;
    }

    public void setJie(String jie) {
        this.jie = jie;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }

    public String getDfzh() {
        return dfzh;
    }

    public void setDfzh(String dfzh) {
        this.dfzh = dfzh;
    }

    public String getDfzhName() {
        return dfzhName;
    }

    public void setDfzhName(String dfzhName) {
        this.dfzhName = dfzhName;
    }

    public String getJylsh() {
        return jylsh;
    }

    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    @Override
    public String toString() {
        return "PAB{" +
                "date='" + date + '\'' +
                ", zh='" + zh + '\'' +
                ", jie='" + jie + '\'' +
                ", dai='" + dai + '\'' +
                ", dfzh='" + dfzh + '\'' +
                ", dfzhName='" + dfzhName + '\'' +
                ", jylsh='" + jylsh + '\'' +
                ", zy='" + zy + '\'' +
                ", yt='" + yt + '\'' +
                '}';
    }
}
