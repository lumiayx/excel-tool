package com.yx;

import com.yx.controller.OnLineController;
import com.yx.controller.RansomController;
import com.yx.controller.ResultController;
import com.yx.excel.util.ExcelExportUtil;
import com.yx.excel.util.PropertiesManager;
import com.yx.model.online.SCSJ;
import com.yx.model.ransom.EYT;
import com.yx.model.ransom.GQT;
import com.yx.model.ransom.SLTZDATA;
import com.yx.model.ransom.SLTZDATACOMMON;

import java.util.List;
import java.util.Map;

/**
 * 主程序入口
 * Created by wb0006 on 2017/12/4.
 */
public class MainController {

    public static void main(String[] args) {

        List<SLTZDATA> scList = OnLineController.readExcel();
        List<SLTZDATA> slList = RansomController.readExcel();

        //eg:  赎楼有的 生产没有的   以合同号
        int[] compareFileArr = new int[]{0, 1, 0, 0, 0, 0, 0};
        int[] vaildFileArr = new int[]{1, 1, 1, 1, 1, 1, 1};


        //基准字段
        //int[] compareFileArr = new int[]{0, 1, 0, 0, 0, 0, 0};
        //有效字段
        //int[] vaildFileArr = new int[]{1, 1, 1, 1, 1, 1, 1};
        Map<String, List<SLTZDATA>> map = ResultController.equalResult(scList, slList, compareFileArr, vaildFileArr);
        String onlineDiff = "D://onlineDiff.xls";
        String ransomDiff = "D://ransomDiff.xls";
        if(map.get("onlineDiff").size() > 0){
            ExcelExportUtil.exportToFile(map.get("onlineDiff"), onlineDiff);
        }
        if(map.get("ransomDiff").size() > 0){
            ExcelExportUtil.exportToFile(map.get("ransomDiff"), ransomDiff);
        }

        List<SLTZDATACOMMON> diffCommonList = ResultController.diffResult(map.get("onlineCommon"), map.get("ransomCommon"), compareFileArr,vaildFileArr);
        String diffCommon = "D://diffCommon.xls";
        if(diffCommonList.size() > 0){
            ExcelExportUtil.exportToFile(diffCommonList, diffCommon);
        }

        System.out.println("end...");
    }
}
