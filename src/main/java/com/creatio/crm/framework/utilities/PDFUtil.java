package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {

	public static String readPdfData(String fileName, int startPage,int endPage) {
		
		String pdfData=" ";
		
		try {
		//Read pdf file from specific folder
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Files\\"+fileName);
		
		//Load file to PDDocument inbuilt class to analyze file
		PDDocument doc = PDDocument.load(fis);
		
		//Extract data using PDFTextStripper inbuilt class
		PDFTextStripper pdf = new PDFTextStripper();
		pdf.setStartPage(startPage);
		pdf.setEndPage(endPage);
		
		pdfData=pdf.getText(doc);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pdfData ;
		
	}
}
