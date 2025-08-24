package com.automation.framework.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class for reading Excel test data
 */
public class ExcelUtils {
    private static final String TEST_DATA_PATH = "src/test/resources/testdata/";

    public static Map<String, String> readTestData(String fileName, String sheetName, int rowNum) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        try (Workbook workbook = WorkbookFactory.create(new File(TEST_DATA_PATH + fileName))) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowNum);
            
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).getStringCellValue();
                String value = dataRow.getCell(i).getStringCellValue();
                dataMap.put(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + fileName, e);
        }
        return dataMap;
    }
}
