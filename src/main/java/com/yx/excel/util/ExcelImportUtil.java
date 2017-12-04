package com.yx.excel.util;

import com.yx.excel.annotation.ExcelSheet;
import com.yx.excel.util.FieldReflectionUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Excel导入工具
 *
 */
public class ExcelImportUtil {
    private static Logger logger = LoggerFactory.getLogger(ExcelImportUtil.class);

    /**
     * 从Workbook导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param workbook
     * @param sheetName
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, Workbook workbook, String sheetName) {
        try {
            // sheet
            ExcelSheet excelSheet = sheetClass.getAnnotation(ExcelSheet.class);
            //String sheetName = (excelSheet!=null && excelSheet.name()!=null && excelSheet.name().trim().length()>0)?excelSheet.name().trim():sheetClass.getSimpleName();

            // sheet field
            List<Field> fields = new ArrayList<Field>();
            if (sheetClass.getDeclaredFields()!=null && sheetClass.getDeclaredFields().length>0) {
                for (Field field: sheetClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    fields.add(field);
                }
            }

            if (fields==null || fields.size()==0) {
                throw new RuntimeException(">>>>>>>>>>> xxl-excel error, data field can not be empty.");
            }

            // sheet data
            Sheet sheet = workbook.getSheet(sheetName);

            Iterator<Row> sheetIterator = sheet.rowIterator();
            int rowIndex = 0;
            List<Object> dataList = new ArrayList<Object>();
            while (sheetIterator.hasNext()) {
                Row rowX = sheetIterator.next();
                if (rowIndex > 0) {
                    Object rowObj = sheetClass.newInstance();
                    for (int i = 0; i < fields.size(); i++) {
                        Field field = fields.get(i);
                        String fieldValueStr = "";
                        if(rowX.getCell(i) != null){
                            switch (rowX.getCell(i).getCellType()) {
                                case Cell.CELL_TYPE_STRING:
                                    fieldValueStr = rowX.getCell(i).getStringCellValue() == null ? "" : rowX.getCell(i).getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    if(HSSFDateUtil.isCellDateFormatted(rowX.getCell(i))){
                                        Date date = rowX.getCell(i).getDateCellValue();
                                        if(date != null){
                                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                            fieldValueStr = format.format(date);
                                        }
                                    }else
                                    {
                                        Double d = rowX.getCell(i).getNumericCellValue();
                                        if(d != null){
                                            fieldValueStr = String.valueOf(d);
                                        }
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }

                        Object fieldValue = FieldReflectionUtil.parseValue(field, fieldValueStr);
                        //System.out.println(fieldValue);

                        field.setAccessible(true);
                        field.set(rowObj, fieldValue);
                    }
                    dataList.add(rowObj);
                }
                rowIndex++;
            }
            return dataList;
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param excelFile
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, File excelFile, String sheetName) {
        try {
            Workbook workbook = WorkbookFactory.create(excelFile);
            List<Object> dataList = importExcel(sheetClass, workbook,sheetName);
            return dataList;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 从文件路径导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param filePath
     * @param sheetName
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, String filePath, String sheetName) {
        File excelFile = new File(filePath);
        List<Object> dataList = importExcel(sheetClass, excelFile, sheetName);
        return dataList;
    }

    /**
     * 导入Excel数据流，并封装成对象
     *
     * @param sheetClass
     * @param inputStream
     * @param sheetName
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, InputStream inputStream, String sheetName) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            List<Object> dataList = importExcel(sheetClass, workbook, sheetName);
            return dataList;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
