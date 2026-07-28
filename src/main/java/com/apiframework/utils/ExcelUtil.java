package com.apiframework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";

    public static String getCellData(String sheetName, int rowNum, int cellNum) {

        String data = "";

        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);

            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);

            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}