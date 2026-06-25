package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	//common method to read excel data and convert to 2D array--->.xls :HSSF; .xlsx--XSSF
	public static String[][] readData(String fileName,String sheetName){
		
		String[][] data=null;
		
		try {
			//Read excel file using FileInputStream class
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			
			//Using XSSFWorkbook, analyze excel file
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			
			//Get specific sheet from workbook
			HSSFSheet sheet = wb.getSheet(sheetName);
			
			//Get total no of rows and columns
			int totRows= sheet.getPhysicalNumberOfRows();
			int totCols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			//Initialize 2D array with totRows-1 and totColumns
			data= new String[totRows-1][totCols];//excluding header row
			
			//Loop through rows and columns to read data
			
			for(int r=1; r <totRows; r++) {
				for(int c=0; c <totCols; c++) {
					data[r-1][c]=sheet.getRow(r).getCell(c).getStringCellValue();
				}
				wb.close();
			}
							
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return data;
		
	}
	
	
	//common method to read excel data and convert to List<Map<String,String>>
		public static List<Map<String,String>> readExcelList(String fileName,String sheetName){
			
			//Placeholder for list to hold data reading from excel
			List<Map<String,String>> data=new ArrayList<Map<String,String>>();
			
			try {
				//Read excel file using FileInputStream class
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
				
				//Using XSSFWorkbook, analyze excel file
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				
				//Get specific sheet from workbook
				HSSFSheet sheet = wb.getSheet(sheetName);
				
				//Get total no of rows and columns
				int totRows= sheet.getPhysicalNumberOfRows();
				int totCols = sheet.getRow(0).getPhysicalNumberOfCells();
				
				//Loop through rows and columns to read data
				
				for(int r=1; r <totRows; r++) {
					//create new map for each row
					Map<String,String> rowData = new HashMap<String, String>();
					
					//Iterate over each column
					for(int c=0; c <totCols; c++) {
						
						//get key from header row(0th row)
						String key=sheet.getRow(0).getCell(c).getStringCellValue();
						
						//get value from current row
						String value=sheet.getRow(r).getCell(c).getStringCellValue();
						
						//put key,value into map
						rowData.put(key, value);
						
						//Add map to List
						data.add(rowData);
					}
					wb.close();
				}
								
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			return data;
			

      }
}