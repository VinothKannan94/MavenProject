package com.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {

    /**
     * syntax : Workbook reference = new xssfworkbook();
     */
    public static String getSearchInput (int rowValue, int columValue) {
        String data = null;
        try {
            File file = new File("C:\\Users\\JECINTHA\\Downloads\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet2");

                Row row = sheet.getRow(rowValue);

                    Cell cell = row.getCell(columValue);

                    DataFormatter dataFormatter = new DataFormatter();
                    data = dataFormatter.formatCellValue(cell);
                    System.out.println(data + "");
                    book.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
