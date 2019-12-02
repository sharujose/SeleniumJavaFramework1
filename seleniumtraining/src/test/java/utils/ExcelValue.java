package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelValue {

	//static 
	XSSFWorkbook workBook ;
	//static 
	XSSFSheet sheet;
	public ExcelValue(String workbook,String sheetname) throws Exception 
	{
		//XSSFWorkbook 
		workBook = new XSSFWorkbook(workbook);
		//XSSFSheet  
		sheet = workBook.getSheet(sheetname);
	}

	public  int getRowCount() 
	{

		return sheet.getPhysicalNumberOfRows();
	}

	public  int getColCount() 
	{
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}


	public  String getCellValue(int rownum , int colnum) 
	{
		String cellData=null;
		cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return cellData;
	}

}
