package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckBoxTestObject;
import utils.ExcelValue;


public class CheckBoxTest {

	static WebDriver driver;
	static String workbookPath;
	static String sheetName;

	@BeforeTest()
	public static void setupTest() {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	@DataProvider(name = "checkboxdata")
	public Object[] checkboxData() throws Exception
	{
		workbookPath ="A:\\Java\\Workspace\\seleniumtraining\\src\\test\\java\\utils\\FB.xlsx";
		sheetName = "Sheet2";
		Object[] data = getExcelValue();
		return data;

	}

	public  Object[] getExcelValue() throws Exception
	{
		ExcelValue ob = new ExcelValue(workbookPath,sheetName);

		int rowCount = ob.getRowCount();

		Object[] DataValue = new Object[rowCount];

		for( int i =0; i<rowCount; i++)
		{
			int j=0;
			String cellData = ob.getCellValue(i, j);
			DataValue[i]=cellData;

		}
		return DataValue;
	}



	@Test(dataProvider = "checkboxdata")
	public static void testCheckBox1(String checkboxValue) 
	{

		CheckBoxTestObject testObject = new CheckBoxTestObject(driver);
		testObject.testCheckBox(checkboxValue);


	}

	@AfterTest()
	public void tearDown()
	{
		driver.close();
	}
}
