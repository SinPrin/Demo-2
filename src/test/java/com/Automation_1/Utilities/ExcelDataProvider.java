package com.Automation_1.Utilities;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("C:/Users/Prince/git/Se_Automation/Automation_1/TestData/ExcelData.xlsx");

		try {
			FileInputStream fis= new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excelfile: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getStringData(String sheetName, int row, int cell) {
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public String getStringData(int sheetidx, int row, int cell) {
		return wb.getSheetAt(sheetidx).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double getDoubleData(String sheetName, int row, int cell) {
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}

}
