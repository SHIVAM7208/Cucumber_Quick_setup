package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    // Read value from Excel
    public static String readExcel(String excelFilePath, int sheetIndex, int rowNum, int cellNum) {
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);
            return cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
 // Write value to Excel
    public static void writeExcel(String excelFilePath, int sheetIndex, int rowNum, int cellNum, String value) {
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            Cell cell = row.createCell(cellNum);
            cell.setCellValue(value);
            
            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
