package test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData {
	
	public static String[][] getData (String excelfilename)throws IOException{

		XSSFWorkbook excel = new XSSFWorkbook("./TestData/"+excelfilename+".xlsx");
		XSSFSheet sheet=excel.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		System.out.println("Row count is: "+ rowCount);
		int colCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Column count is: "+colCount);
		String data[][]=new String[rowCount][colCount];
		for(int row=1;row<=rowCount;row++) {
			XSSFRow eachrow=sheet.getRow(row);
			for (int column=0;column<colCount;column++) {
				XSSFCell cell=eachrow.getCell(column);
				String cellvalue=cell.getStringCellValue();
				data[row-1][column]=cellvalue;
				
			}
		}
		excel.close();
		return data;
		
	}
		



	}

