package com.ExcelFileReader.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    public List<Map<String, Object>> readExcel(String filePath) {
        List<Map<String, Object>> dataList = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Skip header (row 0)
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, Object> rowData = new HashMap<>();
                rowData.put("ID", (int) row.getCell(0).getNumericCellValue());
                rowData.put("Name", row.getCell(1).getStringCellValue());
                rowData.put("Salary", row.getCell(2).getNumericCellValue());

                dataList.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
