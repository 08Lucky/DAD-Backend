package com.capstone.dad.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.dad.controller.FileUploadController;
import com.capstone.dad.entity.ExcelData;
import com.capstone.dad.repo.ExcelDataRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Component
public class ExcelDataScheduler {

	private final ExcelDataProducer excelDataProducer;
    private final ExcelDataRepository excelDataRepository;
    private final ExcelDataConsumer excelDataConsumer;

    public ExcelDataScheduler(ExcelDataProducer excelDataProducer, ExcelDataRepository excelDataRepository,
                               ExcelDataConsumer excelDataConsumer) {
        this.excelDataProducer = excelDataProducer;
        this.excelDataRepository = excelDataRepository;
        this.excelDataConsumer = excelDataConsumer;
    }

    @Scheduled(fixedRate = 3600000) // Run every hour (in milliseconds)
    public void loadExcelData(MultipartFile file) {
        List<ExcelData> excelDataList = readExcelFile(file); // Read Excel file and get data

        for (ExcelData data : excelDataList) {
            excelDataProducer.sendExcelData(data);
        }
    }

    private List<ExcelData> readExcelFile(MultipartFile file) {
        List<ExcelData> excelDataList = new ArrayList<>();
        
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet
            
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header row
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                ExcelData excelData = createExcelDataFromRow(row);
                if (excelData != null) {
                    excelDataList.add(excelData);
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return excelDataList;
    }

    private ExcelData createExcelDataFromRow(Row row) {
        ExcelData excelData = new ExcelData();

        excelData.setSr_no(getDoubleCellValue(row.getCell(0)));
        excelData.setSol_id(getDoubleCellValue(row.getCell(1)));
        excelData.setAcct_name(getStringCellValue(row.getCell(2)));
        excelData.setSchm_code(getStringCellValue(row.getCell(3)));
        excelData.setPrincipal_payment_due_date(getStringCellValue(row.getCell(4)));
        excelData.setPrincipal_payment_amount(getDoubleCellValue(row.getCell(5)));
        excelData.setInterest_payment_due_date(getStringCellValue(row.getCell(6)));
        excelData.setPrimary_manager_id(getStringCellValue(row.getCell(7)));
        excelData.setSecondary_manager_id(getDoubleCellValue(row.getCell(8)));
        excelData.setTertiary_manager_id(getDoubleCellValue(row.getCell(9)));
        excelData.setCbo_srm_id(getDoubleCellValue(row.getCell(10)));
        excelData.setCredit_admin_manager_id(getDoubleCellValue(row.getCell(11)));
        excelData.setNormal_interest(getDoubleCellValue(row.getCell(12)));
        excelData.setInterest_calc_status(getStringCellValue(row.getCell(13)));
        excelData.setPenal_interest(getDoubleCellValue(row.getCell(14)));
        excelData.setPenal_calc_status(getStringCellValue(row.getCell(15)));
        excelData.setProcessing_status(getStringCellValue(row.getCell(16)));
        
        return excelData;
    }
    
    
    
    private Object getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return null;
        }
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return null;
        }
    }


    private Double getDoubleCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return null; 
                }
            default:
                return null;
        }
    }


    
    private void saveOrUpdateExcelData(ExcelData excelData) {
        if (!excelDataRepository.existsBySr_no(excelData.getSr_no())) {
            excelDataRepository.save(excelData);
        }
    }
}
