package com.yx;

import com.yx.controller.OnLineController;
import com.yx.controller.RansomController;
import com.yx.controller.ResultController;
import com.yx.model.online.SCSJ;
import com.yx.model.ransom.GQT;
import com.yx.model.ransom.SLTZDATA;

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

        Map<String, List<SLTZDATA>> map = ResultController.equalResult(scList, slList, new int[]{0, 0, 0, 0, 0, 0, 0});

        
        System.out.println("...");
    }
}
