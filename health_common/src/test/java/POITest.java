import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class POITest {
    //使用POI读取Excel文件中的数据
    @Test
    public void test1() throws Exception {
        //加载指定文件，创建一个Excel对象（工作簿）
        XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("F:\\poi.xlsx")));
        //读取Excel文件中第一个Sheet标签页(既可以根据工作表的顺序获取，也可以根据工作表的名称获取)
        XSSFSheet sheet = excel.getSheetAt(0);
        //遍历工作表获得行对象
        for (Row row : sheet) {
            //遍历行对象获得单元格对象
            for (Cell cell : row) {
                //获得单元格中的值
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
        excel.close();
    }

    @Test
    public void test2() throws Exception {
        //加载指定文件，创建一个Excel对象（工作簿）
        XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("F:\\poi.xlsx")));
        //读取Excel文件中第一个Sheet标签页(既可以根据工作表的顺序获取，也可以根据工作表的名称获取)
        XSSFSheet sheet = excel.getSheetAt(0);
        //获取当前工作表中最后一个行号，需要注意，行号从0开始
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);//根据行号获取每一行
            //获取当前行最后一个单元格
            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++){
                XSSFCell cell = row.getCell(j);//根据单元格索引获得单元格对象
                System.out.println(cell.getStringCellValue());
            }
        }
        excel.close();
    }

    @Test
    public void test3() throws Exception {
        //在内存中创建一个Excel文件
        XSSFWorkbook excel = new XSSFWorkbook();
        //创建工作表，指定工作表名称
        XSSFSheet sheet = excel.createSheet("传智健康");

        //创建行，0行表示第一行
        XSSFRow row = sheet.createRow(0);
        //创建单元格，0表示第一个单元格
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("年龄");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("小明");
        row1.createCell(2).setCellValue("10");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("2");
        row2.createCell(1).setCellValue("小军");
        row2.createCell(2).setCellValue("20");

        FileOutputStream out = new FileOutputStream("F:\\hello.xlsx");
        excel.write(out);
        out.flush();
        out.close();
        excel.close();
    }
}
