package edu.handong.csee.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class excelReader {
	
	public ArrayList<String> getData(InputStream is, boolean removeHeader, int fileNum){
		ArrayList<String> values = new ArrayList<String>();
		
	
	try(InputStream input = is) {
		Workbook workbook = WorkbookFactory.create(input);
		Sheet sheet = workbook.getSheetAt(0);
		
		for(int indexOfRow = sheet.getFirstRowNum() +1; indexOfRow<sheet.getPhysicalNumberOfRows(); indexOfRow++) {
			String line ="";
			Row row = sheet.getRow(indexOfRow);
			
			for(int indexOfCell = row.getFirstCellNum(); indexOfCell<row.getPhysicalNumberOfCells(); indexOfCell++) {
				Cell cell = row.getCell(indexOfCell);
				
				try {
					line = line + "\"" + cell.getStringCellValue().replaceAll("\"", "") + "\"";
				} catch(IllegalStateException e) {
					line = line + "\"" + cell.getNumericCellValue() + "\"";
				}
				
				if(indexOfCell != row.getPhysicalNumberOfCells() -1) {
					line = line + ",";
				}
				
			}
			values.add(line);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();
	}
	return values;
}
}
	
	
