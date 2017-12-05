package com.yx.excel.util;

import java.text.SimpleDateFormat;

/**
 * Created by wb0006 on 2017/12/5.
 */
public class DataUtil {
    //钱补零
    public static String changeMoney(String money){
        if(money == null || "".equals(money)){
            return "";
        }else{
            String[] moneyArr = money.split("\\.");
            if(moneyArr.length == 1){
                return moneyArr + ".0000";
            }else{
                int addZero = moneyArr[1].length();
                String flag = "";
                switch (addZero){
                    case 0:
                        flag = "0000";
                        break;
                    case 1:
                        flag = "000";
                        break;
                    case 2:
                        flag = "00";
                        break;
                    case 3:
                        flag = "0";
                        break;
                    case 4:
                        flag = "";
                        break;
                }
                return money + flag;
            }
        }
    }

    public static String changeDate(String date){
        if(date == null || "".equals(date)){
            return "";
        }else{
          if(date.contains("/")){
              String[] dateArr = date.split("/");
              return dateArr[0] + "-" + (dateArr[1].length() > 1 ? dateArr[1] : "0"+dateArr[1]) + "-" + (dateArr[2].length()>1 ? dateArr[2] : "0"+dateArr[2]);
          }else{
              return date;
          }
        }
    }

}
