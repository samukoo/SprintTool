package com.samuk.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.samuk.orm.Committer;
import com.samuk.orm.Container;
import com.samuk.orm.Member;
import com.samuk.orm.Sprint;

public class Import {

	private final String SHEET = "Sprint Calculator";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		Import i = new Import();

		
		i.readMembers();
		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Sprint> readExcell() throws Exception {
		
		/**
		 * Load file and create input stream
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sprintcalculator.xlsx")
				.getFile());
		FileInputStream fis = new FileInputStream(file);
		
		/**
		 * Open workbook and sheet
		 */
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sprint Calculator");
		
		List<Row> rowList = new ArrayList<Row>();

		/**
		 * Read every row from the sheet to memory
		 */
		for (int j = 1; j < sheet.getLastRowNum(); j++) {
			Row r = sheet.getRow(j);
			rowList.add(r);
		}
		
		/**
		 * Close files and input streams
		 */
		wb.close();
		fis.close();

		List<Sprint> sprintList = new ArrayList<Sprint>();
		
		/**
		 * j = column number (Column = sprint number)
		 */
		for (int j = 1; j < 7; j++) {
			Sprint sprint = new Sprint();
					sprint.setWeek(Util.parseInt(rowList.get(1).getCell(j).toString()));
					sprint.setDate(rowList.get(2).getCell(j).getDateCellValue());
					sprintList.add(sprint);
		}
		return sprintList;
	}

	public Container readCommitters() throws Exception{
		/**
		 * Load file and create input stream
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sprintcalculator.xlsx")
				.getFile());
		FileInputStream fis = new FileInputStream(file);
		
		/**
		 * Open workbook and sheet
		 */
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sprint Calculator");
		
		List<Row> rowList = new ArrayList<Row>();
		
		/**
		 * Read every row from the sheet to memory
		 */
		for (int j = 1; j < sheet.getLastRowNum(); j++) {
			Row r = sheet.getRow(j);
			rowList.add(r);
		}
		
		/**
		 * Close files and input streams
		 */
		wb.close();
		fis.close();
		
		Container container = new Container();
		
		List<Sprint> sprintList = new ArrayList<Sprint>();
		List<Member> memberList = readMembers();
		List<Committer> committerList = new ArrayList<Committer>();
		
		/**
		 * j = column number (Column = sprint number)
		 */
		
		
		
		for (int j = 1; j < 2; j++) {
			
			
			Sprint sprint = new Sprint();
			sprint.setWeek(Util.parseInt(rowList.get(1).getCell(j).toString()));
			sprint.setDate(rowList.get(2).getCell(j).getDateCellValue());
			sprintList.add(sprint);	
			
			
			
				for(int i = 3 ; i<8 ; i++){
					Committer c = new Committer();
					
					int count = i-3;
					
//					c.setMember(memberList.get(count));
					c.setCommittedPoints((int) Double.parseDouble(rowList.get(i).getCell(1).toString()));
					
//					c.setSprint(sprint);
					
					committerList.add(c);
				}
					
				
					
					
					
		}
		
		container.setSprintList(sprintList);
		container.setCommitterList(committerList);
		
		return container;
		
	}
	
	
	
	
	
	
	
	
	
	public List<Member> readMembers() throws Exception {
		List<Member> membersList = new ArrayList<Member>();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sprintcalculator.xlsx")
				.getFile());
		FileInputStream fis = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(SHEET);

		for (int i = 5; i < 12; i++) {
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
