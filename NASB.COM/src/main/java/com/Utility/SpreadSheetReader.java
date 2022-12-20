package com.Utility;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadSheetReader {
	public static String reader(String path, int r, int c, int sheetNum) throws Exception
	{
	
	String excelFilePath = path;
	FileInputStream inputstream = new FileInputStream (excelFilePath);
	XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheetAt(sheetNum); //"Sheet1"
	
	XSSFRow row = sheet.getRow(r);
	XSSFCell cell=row.getCell(c);
	workbook.close();
	return cell.getStringCellValue();
	}
	public static String dateReader(String path, int r, int c, int sheetNum) throws Exception
	{
	
	String excelFilePath = path;
	FileInputStream inputstream = new FileInputStream (excelFilePath);
	XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheetAt(sheetNum); //"Sheet1"
	
	XSSFRow row = sheet.getRow(r);
	XSSFCell cell=row.getCell(c);
	workbook.close();
	
	SimpleDateFormat te=new SimpleDateFormat("MM/dd/YYYY");
	
	
//	System.out.println(te.format(cell.getDateCellValue()));
	return te.format(cell.getDateCellValue());
	}

}
