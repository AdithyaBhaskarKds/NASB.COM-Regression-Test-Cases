package com.Utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeadIDReaderFromExcel {
	public static String reader(String path, int c) throws Exception
	{
	
	String excelFilePath = path;
	FileInputStream inputstream = new FileInputStream (excelFilePath);
	XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheet("LeadData"); //"Sheet1"
	int lastRow=sheet.getLastRowNum();
	XSSFRow row = sheet.getRow(lastRow);
	XSSFCell cell=row.getCell(c);
	workbook.close();
	return cell.getStringCellValue();
	
			
	}

}
