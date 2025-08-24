package com.automation.framework.utils;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for reading CSV files
 */
public class CSVUtils {
    public static List<Map<String, String>> readCSV(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext();
            String[] line;
            
            while ((line = reader.readNext()) != null) {
                Map<String, String> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], line[i]);
                }
                data.add(row);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file", e);
        }
        return data;
    }
}
