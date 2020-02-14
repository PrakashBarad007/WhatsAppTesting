package com.whatsApp.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.whatsApp.base.WhatsAppBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonDataProvider extends WhatsAppBase{
	
	@DataProvider(name="singleContact",indices = {0})
	public Object[][] singleContact() throws IOException {
		
		Object[][] arrayObject = getExcelData(System.getProperty("user.dir")+"\\src\\test\\resources\\SourceFile\\ContactMemberList.xlsx","Members");
		return arrayObject;
	}
	
	@DataProvider(name="multipleContact")
	public Object[][] multipleContact() throws IOException {
		
		Object[][] arrayObject = getExcelData(System.getProperty("user.dir")+"\\src\\test\\resources\\SourceFile\\ContactMemberList.xlsx","Members");
		return arrayObject;
	}
	
	@DataProvider(name="devicename")
	public Object[][] getDeviceName() throws IOException {
		
		Object[][] arrayObject = getExcelData(System.getProperty("user.dir")+"\\src\\test\\resources\\SourceFile\\ContactMemberList.xlsx","deviceinfo");
		return arrayObject;
	}
	
	public String[][] getExcelData(String fileName, String sheetName) throws IOException {
		String[][] arrayExcelData = null;
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		fis = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		int totalNoOfRows = sheet.getLastRowNum()+1;
		System.out.println(totalNoOfRows);
		List<String> list = new ArrayList<String>();
		
		for (int i= 1 ; i < totalNoOfRows; i++) {
		
			list.add(sheet.getRow(i).getCell(0).getStringCellValue());
		
		} 
		arrayExcelData = new String[list.size()][1];
		for(int i=0;i<list.size();i++) {
			arrayExcelData[i][0] = list.get(i);
			
		}
	return arrayExcelData;
}
	
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	
}
