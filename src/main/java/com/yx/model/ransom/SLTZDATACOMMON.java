package com.yx.model.ransom;

import com.yx.excel.annotation.ExcelField;
import com.yx.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Created by wb0006 on 2017/12/4.
 */
@ExcelSheet(name = "对比", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class SLTZDATACOMMON {
    @ExcelField(name = "对比字段")
    public String diff;

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

    @ExcelField(name = "分割")
    public String split;

    @ExcelField(name = "2客户名")
    public String name2;
    @ExcelField(name = "2合同编号")
    public String htbh2;
    @ExcelField(name = "2客户身份证件")
    public String khsfzh2;
    @ExcelField(name = "2出款金额")
    public String ckmoney2;
    @ExcelField(name = "2产品名")
    public String proName2;
    @ExcelField(name = "2放款日期")
    public String fkTime2;
    @ExcelField(name = "2利息金额")
    public String curMoney2;


    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

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

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getHtbh2() {
        return htbh2;
    }

    public void setHtbh2(String htbh2) {
        this.htbh2 = htbh2;
    }

    public String getKhsfzh2() {
        return khsfzh2;
    }

    public void setKhsfzh2(String khsfzh2) {
        this.khsfzh2 = khsfzh2;
    }

    public String getCkmoney2() {
        return ckmoney2;
    }

    public void setCkmoney2(String ckmoney2) {
        this.ckmoney2 = ckmoney2;
    }

    public String getProName2() {
        return proName2;
    }

    public void setProName2(String proName2) {
        this.proName2 = proName2;
    }

    public String getFkTime2() {
        return fkTime2;
    }

    public void setFkTime2(String fkTime2) {
        this.fkTime2 = fkTime2;
    }

    public String getCurMoney2() {
        return curMoney2;
    }

    public void setCurMoney2(String curMoney2) {
        this.curMoney2 = curMoney2;
    }

    @Override
    public String toString() {
        return "SLTZDATACOMMON{" +
                "diff='" + diff + '\'' +
                ", name='" + name + '\'' +
                ", htbh='" + htbh + '\'' +
                ", khsfzh='" + khsfzh + '\'' +
                ", ckmoney='" + ckmoney + '\'' +
                ", proName='" + proName + '\'' +
                ", fkTime='" + fkTime + '\'' +
                ", curMoney='" + curMoney + '\'' +
                ", name2='" + name2 + '\'' +
                ", htbh2='" + htbh2 + '\'' +
                ", khsfzh2='" + khsfzh2 + '\'' +
                ", ckmoney2='" + ckmoney2 + '\'' +
                ", proName2='" + proName2 + '\'' +
                ", fkTime2='" + fkTime2 + '\'' +
                ", curMoney2='" + curMoney2 + '\'' +
                '}';
    }
}
