package com.palakgupta.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class UtilExcel {

    public static String SHEET_PATH=System.getProperty("user.dir")+"/src/test/resources/DEMOQA_TESTDATA.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    public static Object[][] getTestDataFromExcel(String sheetName){
        try {
            FileInputStream fileInputStream = new FileInputStream(SHEET_PATH);
            workbook= WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            System.out.println("File Now Found!");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i < sheet.getLastRowNum();i++){
            for(int j=0; j < sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;

    }
}
