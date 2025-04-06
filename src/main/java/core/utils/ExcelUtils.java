package core.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

    public class ExcelUtils {

        public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
            String cellData = "";
            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                Row row = sheet.getRow(rowNum);
                Cell cell = row.getCell(colNum);

                cellData = getFormattedCellValue(cell);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return cellData;
        }

        private static String getFormattedCellValue(Cell cell) {
            if (cell == null) return "";
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }


}
