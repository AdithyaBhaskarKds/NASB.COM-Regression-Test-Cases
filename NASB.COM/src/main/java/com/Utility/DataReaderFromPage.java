package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderFromPage {
	public void dataReader(String Fname, String Lname, String LS, String Status, String ID, String vPoint) throws IOException
	{

		
		String excelFilePath = System.getProperty("user.dir").replaceAll("\\\\", "//")+ "//src//test//resources//LeadVerifiedData.xlsx";
		FileInputStream inputstream = new FileInputStream (excelFilePath);
		XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheet("LeadData");
		int rowCount =sheet.getLastRowNum();
		if(rowCount<0)
		{
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("FirstName");
		sheet.getRow(0).createCell(1).setCellValue("LastName");
		sheet.getRow(0).createCell(2).setCellValue("LeadSouece");
		sheet.getRow(0).createCell(3).setCellValue("Status");
		sheet.getRow(0).createCell(4).setCellValue("LeadID");
		sheet.getRow(0).createCell(5).setCellValue("Verify Point");
		}
		//Reading Lead Data
		sheet.createRow(rowCount+1);
		sheet.getRow(rowCount+1).createCell(0).setCellValue(Fname);
		sheet.getRow(rowCount+1).createCell(1).setCellValue(Lname);
		sheet.getRow(rowCount+1).createCell(2).setCellValue(LS);
		sheet.getRow(rowCount+1).createCell(3).setCellValue(Status);
		sheet.getRow(rowCount+1).createCell(4).setCellValue(ID);
		sheet.getRow(rowCount+1).createCell(5).setCellValue(vPoint);
		
		FileOutputStream fo=new FileOutputStream(excelFilePath);
		workbook.write(fo);
		workbook.close();
		
		
		
	}

}
