package com.yx.model.ransom;

import com.yx.excel.annotation.ExcelField;
import com.yx.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Created by wb0006 on 2017/12/4.
 */
@ExcelSheet(name = "对比", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class SLTZDATA {
    @ExcelField(name = "客户名")
    public String name;
    @ExcelField(name = "合同编号")
    public String htbh;
    @ExcelField(name = "客户身份证件")
    public String khsfzh;
    @ExcelField(name = "出款金额")
    public String ckmoney;
    @ExcelField(name = "产品名")
    public String proName;
    @ExcelField(name = "放款日期")
    public String fkTime;
    @ExcelField(name = "利息金额")
    public String curMoney;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public String getKhsfzh() {
        return khsfzh;
    }

    public void setKhsfzh(String khsfzh) {
        this.khsfzh = khsfzh;
    }

    public String getCkmoney() {
        return ckmoney;
    }

    public void setCkmoney(String ckmoney) {
        this.ckmoney = ckmoney;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getFkTime() {
        return fkTime;
    }

    public void setFkTime(String fkTime) {
        this.fkTime = fkTime;
    }

    public String getCurMoney() {
        return curMoney;
    }

    public void setCurMoney(String curMoney) {
        this.curMoney = curMoney;
    }

    @Override
    public String toString() {
        return "SLTZDATA{" +
                "name='" + name + '\'' +
                ", htbh='" + htbh + '\'' +
                ", khsfzh='" + khsfzh + '\'' +
                ", ckmoney='" + ckmoney + '\'' +
                ", proName='" + proName + '\'' +
                ", fkTime='" + fkTime + '\'' +
                ", curMoney='" + curMoney + '\'' +
                '}';
    }
}
