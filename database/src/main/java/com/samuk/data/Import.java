package com.samuk.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.samuk.orm.Member;

public class Import {

	private final String SHEET = "Sprint Calculator";
	
	public static void main(String args[]) throws Exception{
		Import i = new Import();
		
		i.readExcell();
	}
	
	public Row readExcell() throws Exception{
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("column-test.xlsx").getFile());
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet = wb.getSheet("Sheet1");
		System.out.println(sheet.getLastRowNum());
		List<Row>rowList=new ArrayList<Row>();
		for(int  j=0 ; j<3 ; j++ ){
			Row r = sheet.getRow(j);
			rowList.add(r);
		
		}
		wb.close();
		fis.close();
		
		Iterator<Row> ri = sheet.rowIterator();
		
		while(ri.hasNext()){
			System.out.println( ri.next().getCell(1).toString() );
		}
		
		/*
		for(Row r:rowList){
			
			Iterator<Cell> ci = r.cellIterator();
			
			while(ci.hasNext()){
				
				System.out.println(ci.next().toString());
				
			}
		
		
		}
		*/
		
		
		
		
		
		
		return null;
	}
	
	public List<Member> readMembers() throws Exception{
		List<Member> membersList = new ArrayList<Member>();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sprintcalculator.xlsx").getFile());
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(SHEET);
		
		for(int i=5;i<12;i++){
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			
			Member member = new Member(cell.getStringCellValue(), null, null);
			membersList.add(member);
			
		}
		wb.close();
		fis.close();
		return membersList;
	}
	
	
}
