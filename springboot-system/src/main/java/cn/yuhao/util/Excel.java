package cn.yuhao.util;

import org.apache.poi.ss.usermodel.Workbook;//,对应Excel文档；

import org.apache.poi.hssf.usermodel.HSSFWorkbook;//，对应xls格式的Excel文档；

import org.apache.poi.xssf.usermodel.XSSFWorkbook;//，对应xlsx格式的Excel文档；

import org.apache.poi.ss.usermodel.Sheet;//，对应Excel文档中的一个sheet；

import org.apache.poi.ss.usermodel.Row;//，对应一个sheet中的一行；

import org.apache.poi.ss.usermodel.Cell;//，对应一个单元格。
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @author imyzt
 * @date 2022/03/21
 * @description 描述信息
 */
public class Excel {
    public static void main(String[] args) {
        Workbook wb =null;
        Sheet sheet = null,sheet1;
        Row row = null,row1;
        List<Map<String,String>> list = null,list1=null;
        String cellData = null;
        String filePath = "/Users/zhangyu/Downloads/sts.xlsx";
        String filePath1 = "/Users/zhangyu/Downloads/越秀物料数据.xls";
        String columns[] = {"rid","prj_code","project_name_city","title","url"};
        String columns1[] = {"project_id","project_name","city","project_savepath","partner_project_code","partner_project_name","biz_id","resource_name","resource_savepath","resource_cover_picture"};
        wb = readExcel(filePath);
        Workbook wb1 = readExcel(filePath1);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<Map<String,String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                Map<String,String> map = new LinkedHashMap<String,String>();
                row = sheet.getRow(i);
                if(row !=null){
                    for (int j=0;j<colnum;j++){
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                    }
                }else{
                    break;
                }
                list.add(map);
            }
        }

        if(wb1 != null){
            //用来存放表中数据
            list1 = new ArrayList<Map<String,String>>();
            //获取第一个sheet
            sheet1 = wb1.getSheetAt(0);
            //获取最大行数
            int rownum1 = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row1 = sheet1.getRow(0);
            //获取最大列数
            int colnum1 = row1.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum1; i++) {
                Map<String,String> map1 = new LinkedHashMap<String,String>();
                row1 = sheet.getRow(i);
                if(row !=null){
                    for (int j=0;j<colnum1;j++){
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map1.put(columns1[j], cellData);
                    }
                }else{
                    break;
                }
                list1.add(map1);
            }
        }
        //遍历解析出来的list
        int i = 1;
        for (Map<String,String> map : list) {
            System.out.print("第"+i+++"行\t");
            for (Entry<String,String> entry : map.entrySet()) {
                System.out.print(entry.getKey()+":"+entry.getValue()+",");
            }
            System.out.println();
        }
         i =1 ;
        for(Map<String,String> map: list1){
            System.out.print("第"+i+++"行\t");
            for (Entry<String,String> entry : map.entrySet()) {
                System.out.print(entry.getKey()+":"+entry.getValue()+",");
            }
            System.out.println();
        }

    }
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }
}