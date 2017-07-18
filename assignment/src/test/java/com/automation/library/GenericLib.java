package com.automation.library;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

public class GenericLib {
	public static String sdirect=System.getProperty("user.dir");
	public static String xlx=sdirect+"//TestData.xlsx";
	public static String config=sdirect+"//config.properties";
	public static String[] sdata;
//reading from properties files
	
	public static String getproperties(String sfile,String key){
		Properties prop = new Properties();
		String value=null;
		try{
			InputStream input= new FileInputStream(sfile);
			prop.load(input);
			value=prop.getProperty(key);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return value;
		
	}
	//reading files from xlsx
	
	public static String[] readxl(String Test_Case_ID){
		try{
			FileInputStream fis=new FileInputStream(xlx);
		  Workbook w = WorkbookFactory.create(fis);
		 Sheet s = w.getSheet("Sheet1");
		 int rn = s.getLastRowNum();
		 for (int i = 0; i < rn; i++) {
			
			 if(Test_Case_ID.equals(s.getRow(i).getCell(0).getStringCellValue())){
				
				
				 sdata=new String[s.getRow(i).getLastCellNum()];
				 for (int j = 0; j <sdata.length ; j++) {
					sdata[j]=s.getRow(i).getCell(j).getStringCellValue();
				}
				 break;
			 }
			
		}
		  
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
		return sdata;
		
	}
	
//to check element status type
	public static void Element_status_type(WebElement element,String element_name,String Check_type){
		
		switch(Check_type){
		case "displayed":
			try{
			element.isDisplayed();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		break;
		case "enabled":
			try{
			element.isEnabled();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		break;
		case "selected":
			try{
			element.isSelected();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		break;
		
	}
	
	}
}

