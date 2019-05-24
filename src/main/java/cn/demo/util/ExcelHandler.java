package cn.demo.util;

import cn.demo.constant.DefaultInfo;
import cn.demo.entity.HostRow;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;

import jxl.write.Number;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * @author
 */
public class ExcelHandler {

    public static List<HostRow> readExcel(String filePath) {
        List<HostRow> hostRows = new ArrayList<>();
        try {

            InputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = Workbook.getWorkbook(inputStream);

            Sheet sheet = workbook.getSheet(DefaultInfo.SHEET_NAME);

            System.out.println(sheet);
            int rsRows = sheet.getRows();

            for (int i = 1; i <  rsRows; i++)
            {
                HostRow row = new HostRow();
                row.setExcelId(sheet.getCell(0, i).getContents());
                String hostType = sheet.getCell(1, i).getContents();
                row.setHostType(hostType);

                if("".equals(hostType)) {
                    hostType = "http";
                }
                String host = sheet.getCell(2, i).getContents();
                row.setHost(host);
                String regex = sheet.getCell(3, i).getContents();
                row.setRegex(regex);
                String dateString = sheet.getCell(4, i).getContents();
                if(!"".equals(dateString)) {

                    row.setUpdateDate(new SimpleDateFormat("yyyy.MM.dd").parse(dateString));
                }
                row.setName(sheet.getCell(5, i).getContents());
                row.setSourceName(sheet.getCell(6, i).getContents());
                row.setSourceType(sheet.getCell(7, i).getContents());
                row.setClass1(sheet.getCell(8, i).getContents());
                row.setSubclass1(sheet.getCell(9, i).getContents());
                row.setSubclass2(sheet.getCell(10, i).getContents());
                row.setStatus(Integer.parseInt(sheet.getCell(11, i).getContents()));

                String url = hostType + "://" + host + regex.replace("\\?", "?");
                row.setUrl(url);
                hostRows.add(row);
            }
            //关闭
            workbook.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return hostRows;
    }

    public static void createExcel(String path, List<HostRow> list) throws WriteException, IOException {
        //创建工作薄
        OutputStream outputStream = new FileOutputStream(new File(path));
        WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet(DefaultInfo.SHEET_NAME, 0);
        //创建要显示的具体内容
        Double[] widthArr = new Double[]{9.08, 9.9, 30.7, 46.14, 11.93, 25.0, 20.91, 16.29, 10.29, 10.91, 35.81, 15.0};
        for(int i=0; i<widthArr.length; i++) {
            int wid = widthArr[i].intValue();
            sheet.setColumnView(i,wid);
        }
        WritableFont writableFont = new WritableFont(WritableFont.createFont("微软雅黑"),10,WritableFont.BOLD);
        WritableCellFormat writableCellFormat = new WritableCellFormat(writableFont);
        writableCellFormat.setAlignment(jxl.format.Alignment.CENTRE);


        sheet.addCell(new Label(0, 0, "id", writableCellFormat));
        sheet.addCell(new Label(1, 0, "host_type", writableCellFormat));
        sheet.addCell(new Label(2, 0, "host", writableCellFormat));
        sheet.addCell(new Label(3, 0, "regex", writableCellFormat));
        sheet.addCell(new Label(4, 0, "update_date", writableCellFormat));
        sheet.addCell(new Label(5, 0, "name", writableCellFormat));
        sheet.addCell(new Label(6, 0, "source_name", writableCellFormat));
        sheet.addCell(new Label(7, 0, "source_type", writableCellFormat));
        sheet.addCell(new Label(8, 0, "class", writableCellFormat));
        sheet.addCell(new Label(9, 0, "subclass_1", writableCellFormat));
        sheet.addCell(new Label(10, 0, "subclass_2", writableCellFormat));
        sheet.addCell(new Label(11, 0, "status", writableCellFormat));

        for(int i=0; i<list.size(); i++) {
            HostRow row = list.get(i);


            sheet.addCell(new Number(0, i+1, i+1, writableCellFormat));
            sheet.addCell(new Label(1, i+1, row.getHostType(), writableCellFormat));
            sheet.addCell(new Label(2, i+1, row.getHost(), writableCellFormat));
            sheet.addCell(new Label(3, i+1, row.getRegex(), writableCellFormat));


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            sheet.addCell(new Label(4, i+1, sdf.format(row.getUpdateDate()), writableCellFormat));

            sheet.addCell(new Label(5, i+1, row.getName(), writableCellFormat));
            sheet.addCell(new Label(6, i+1, row.getSourceName(), writableCellFormat));
            sheet.addCell(new Label(7, i+1, row.getSourceType(), writableCellFormat));
            sheet.addCell(new Label(8, i+1, row.getClass1(), writableCellFormat));
            sheet.addCell(new Label(9, i+1, row.getSubclass1(), writableCellFormat));
            sheet.addCell(new Label(10, i+1, row.getSubclass2(), writableCellFormat));

            sheet.addCell(new Number(11, i+1, row.getStatus(), writableCellFormat));
        }
        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        outputStream.close();
    }
}
