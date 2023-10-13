package com.medblaze.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsutils {
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static FileOutputStream fos;
	
	public static int getrowcount(String xlsfile,String xlsheet) throws IOException {
		fis=new FileInputStream(xlsfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}
	public static int getcellcount(String xlsfile,String Xlsheet) throws IOException {
		fis=new FileInputStream(xlsfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(Xlsheet);
		row=sheet.getRow(1);
		int colcount =row.getLastCellNum();
		workbook.close();
		fis.close();
		return colcount;
	}
	
	public static String getcelldata(String xlsfile,String xlsheet,int rownum,int colnum) throws IOException {
		fis=new FileInputStream(xlsfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellvalue=formatter.formatCellValue(cell);
			return cellvalue;
		}
		catch(Exception e){
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public static void setcellvalue(String xlsfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
		fis=new FileInputStream(xlsfile);
		workbook =new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlsfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
}
