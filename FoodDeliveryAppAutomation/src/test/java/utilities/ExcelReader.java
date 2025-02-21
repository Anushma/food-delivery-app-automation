package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	  // Method to read data from Excel file
    public static String getApplicationURL(String filePath, String sheetName, int row, int col) {
        String cellValue = "";
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            // Load Excel file
            fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            // Get cell value
            cellValue = sheet.getRow(row).getCell(col).getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (workbook != null) workbook.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cellValue;
    }
	}

	


