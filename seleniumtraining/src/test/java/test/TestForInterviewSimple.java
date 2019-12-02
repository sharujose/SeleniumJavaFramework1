package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestForInterviewSimple {

	static WebDriver driver;
	
	@BeforeTest()
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
	}
	
	@DataProvider(name="getDataFromExcel")
	public Object[] excelDataProcider() {
		
		Object[][] data = dataFetch();
		return data;
	}
	
	public Object[][] dataFetch()
	{
//		XSSFWorkbook book = null;
//		try {
//			book = new XSSFWorkbook("A:\\Java\\Workspace\\seleniumtraining\\src\\test\\java\\utils\\FB.xlsx");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		XSSFSheet sheet = book.getSheetAt(0);
//		Integer rownum= sheet.getPhysicalNumberOfRows();
//		Integer colnum = sheet.getRow(0).getPhysicalNumberOfCells();
//		Object[][] exelData = new Object[rownum][colnum];
//		for(int i=1;i<rownum;i++)
//		{
//			for(int j=0;j<colnum;j++)
//			{
//				String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
//				exelData[i-1][j] = cellData;
//			}
//		}
		Object[][] excelData = {{"UNAME","PAWD","NAME"},{"sim","sim@1","simson"}};
		return excelData;
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void testDataLogin()
	{
		
	}
}
