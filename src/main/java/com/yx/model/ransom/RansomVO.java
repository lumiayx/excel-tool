package com.yx.model.ransom;

/**
 * 赎楼台账
 * Created by wb0006 on 2017/12/4.
 */
public class RansomVO {
    public String name;
    public String htbh;
    public String khsfzh;
    public String ckmoney;
    public String proName;
    public String fkTime;
    public String curMoney;

    public RansomVO() {
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

    public RansomVO(String name, String htbh, String khsfzh, String ckmoney, String proName, String fkTime, String curMoney) {
        this.name = name;
        this.htbh = htbh;
        this.khsfzh = khsfzh;
        this.ckmoney = ckmoney;
        this.proName = proName;
        this.fkTime = fkTime;
        this.curMoney = curMoney;
    }

    @Override
    public String toString() {
        return "RansomVO{" +
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
