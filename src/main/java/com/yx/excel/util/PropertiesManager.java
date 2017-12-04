package com.yx.excel.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by wb0006 on 2017/12/4.
 */
public class PropertiesManager {
    public static PropertiesManager propertiesManager;
    public static Properties properties;
    private static final String encode = "UTF-8";//文件的编码格式

    public PropertiesManager() {
        String configFile = "file.properties"; //配置文件路径
        properties = new Properties();
        InputStream in = PropertiesManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            //读取配置文件
            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //通过单例模式实例化个数
    public static PropertiesManager getInstance(){
        if(propertiesManager == null){
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }

    //通过Key获取对应的value的值
    public String getString(String key){
        return properties.getProperty(key);
    }
}
