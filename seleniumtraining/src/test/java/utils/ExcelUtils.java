package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	public  ExcelUtils(String excelPath , String sheetName) throws Exception {

		workBook = new XSSFWorkbook(excelPath);
		sheet = workBook.getSheet(sheetName);
	}

	public int getRowCount() {

		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;

	}

	public int getColCount() {

		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;

	}

	
	public String getCellData(int rownum,int colnum) {
		
		String cellData;
		cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return cellData;
		
	}

}
