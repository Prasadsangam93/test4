package com.ExcelFileReader.controller;

import com.ExcelFileReader.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExcelController {

    @Autowired
    private ExcelService excelService;
    @GetMapping("/read-excel")
    public List<Map<String, Object>> readExcel() {
        String filePath = "C:/Users/Sreenivas Bandaru/Documents/New folder/employee.xlsx";
        return excelService.readExcel(filePath);
    }
}
