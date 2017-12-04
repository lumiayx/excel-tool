package com.yx.template.bank;

import com.yx.excel.annotation.ExcelField;
import com.yx.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 浦发银行
 * Created by wb0006 on 2017/12/4.
 */
@ExcelSheet(name = "history", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class SPDB {

    @ExcelField(name = "交易日期")
    private String date;

    @ExcelField(name = "贷方金额")
    private String dfMoney;

    @ExcelField(name = "对方账号")
    private String dfzh;

    @ExcelField(name = "对方户名")
    private String dfhm;

    @ExcelField(name = "摘要")
    private String zy;

    @ExcelField(name = "备注")
    private String bz;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDfMoney() {
        return dfMoney;
    }

    public void setDfMoney(String dfMoney) {
        this.dfMoney = dfMoney;
    }

    public String getDfzh() {
        return dfzh;
    }

    public void setDfzh(String dfzh) {
        this.dfzh = dfzh;
    }

    public String getDfhm() {
        return dfhm;
    }

    public void setDfhm(String dfhm) {
        this.dfhm = dfhm;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public SPDB() {
    }

    public SPDB(String date, String dfMoney, String dfzh, String dfhm, String zy, String bz) {
        this.date = date;
        this.dfMoney = dfMoney;
        this.dfzh = dfzh;
        this.dfhm = dfhm;
        this.zy = zy;
        this.bz = bz;
    }

    @Override
    public String toString() {
        return "SPDB{" +
                "date='" + date + '\'' +
                ", dfMoney='" + dfMoney + '\'' +
                ", dfzh='" + dfzh + '\'' +
                ", dfhm='" + dfhm + '\'' +
                ", zy='" + zy + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}
