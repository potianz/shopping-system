package cn.yuhao.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.thymeleaf.engine.IterationStatusVar;
import sun.net.idn.StringPrep;

/**
 * @author imyzt
 * @date 2022/03/21
 * @description 描述信息
 */
public class Excel2 {

    public static void main(String[] args) {
        String filePath = "/Users/zhangyu/Downloads/越秀物料数据.xls";
        String filePath1 = "/Users/zhangyu/Downloads/sts.xlsx";
        String columns1[] = {"rid","prj_code","project_name_city","title","url"};
        String columns[] = {"project_id","project_name","city","project_savepath","partner_project_code","partner_project_name","biz_id","resource_name","resource_savepath","resource_cover_picture"};;
        Excel2 excel= new Excel2();
        List<Map<String,String>> list = excel.test(filePath,columns);
        List<Map<String,String>> list1  = excel.test(filePath1,columns1);
//        excel.caifenurl("https://fangbao-oss.yuexiuproperty.cn/icp/yuexiutiancheng_11330/index.html?showpage=vr_tour&showparam=scene_xuanguanmqu2&timestamp=20200716185240");
       int f = 0;
        try {
            txtExport.creatTxtFile("111");
        for (int i = 0; i < list1.size(); i++) {
            String  u =list1.get(i).get("title");
            System.out.println(u);
            String ur = list1.get(i).get("url");
//            System.out.println(excel.caifenurl(ur));
            String a =excel.caifenurl(ur);
            int status = f;
            for (int j = 0; j < list.size(); j++) {
                String name = list.get(j).get("resource_name");
                String save = list.get(j).get("project_savepath");
                if(name.equals(u) && save.equals(a)){
                    f++;
                    String rid   = list1.get(i).get("rid");
                    System.out.println("===============================");
                    System.out.println("rid:\t"+rid);
                    System.out.println("判断成功");
                    System.out.println("\t名字:"+name+"\t项目地址："+save);

                    System.out.println("项目id："+list.get(j).get("project_id")+"\t物料id"+list.get(j).get("biz_id"));
                    System.out.println("================================");
                    txtExport.writeTxtFile("rid:\t"+rid+"\t名称:\t"+name+"\t项目地址：\t"+save+"\t项目id：\t"+list.get(j).get("project_id")+"\t物料id：\t"+list.get(j).get("biz_id"));
                    list.remove(j);
                    break;
                }
            }
            if( f > status){
                //说明 对应上了 删除
                list1.remove(i);
                i--;
            }
        }
        int a = 0;
            txtExport.creatTxtFile("1111");
            for(Map<String,String> map:list){
                for (Entry<String,String> entry : map.entrySet()) {
                System.out.println(entry.getKey()+":"+entry.getValue()+",");
                txtExport.writeTxtFile(entry.getKey()+": "+entry.getValue()+",\t");

                }
                a++;
                txtExport.writeTxtFile("=====================");
            }
            txtExport.writeTxtFile("共"+a+"条数据！");
            System.out.println(list.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFWorkbook workbook1 = new HSSFWorkbook();
        HSSFSheet sheet1 = workbook1.createSheet("云创数据");
        String[] name1 = {"project_id","project_name","project_savepath","partner_project_code","partner_project_name","biz_id","resource_name","resource_savepath","resource_cover_picture"};
        HSSFRow rows = sheet1.createRow(0);
        for (int i = 0; i < name1.length; i++) {
            HSSFCell cell = rows.createCell(i);
            cell.setCellValue(name1[i]);
        }
        for (int i = 1; i <= list.size(); i++) {
            HSSFRow row = sheet1.createRow(i);
            for (int j = 0; j < name1.length; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(list.get(i-1).get(name1[j]));
            }
        }




        System.out.println(f);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("越秀报表");
        String[] name = {"rid","pri_code","project_name_city","title","url"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i <5 ; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(name[i]);
        }

        for (int i = 1; i <= list1.size(); i++) {
            HSSFRow row1 = sheet.createRow(i);
            for (int j = 0; j < 5; j++) {
                HSSFCell cell = row1.createCell(j);
                cell.setCellValue(list1.get(i-1).get(name[j]));
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("/Users/zhangyu/Desktop/越秀未匹配到的数据.xls");
            workbook.write(outputStream);
            outputStream.flush();


            FileOutputStream outputStream1 = new FileOutputStream("/Users/zhangyu/Desktop/越秀物料信息未匹配到表.xls");
            workbook1.write(outputStream1);
            outputStream1.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }
    public String caifenurl(String url){
        String qurl = "https://fangbao-oss.yuexiuproperty.cn/icp/";
        String l = url.replaceAll(qurl,"");
        String[] w = l.split("/");
//        System.out.println(w[0]);
        return  w[0];
    }


    //解析excel
    public List<Map<String,String>> test(String filePath,String[] columns){
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String,String>> list = null;
        String cellData = null;
        wb = readExcel(filePath);
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
        int i = 1;
        //遍历解析出来的list
        for (Map<String,String> map : list) {
//            System.out.print("\t第"+i+++"行\t");
            for (Entry<String,String> entry : map.entrySet()) {
//                System.out.print(entry.getKey()+":"+entry.getValue()+",");
            }
//            System.out.println();
        }
        return list;

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