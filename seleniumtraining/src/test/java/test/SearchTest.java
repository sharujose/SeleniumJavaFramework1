package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SearchPageObjects;
import utils.ExcelUtils;

public class SearchTest {

	static WebDriver driver;

	static String workbookPath;
	static String sheetName;


	@BeforeTest()
	public void setupTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}


	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws Throwable {
		workbookPath ="A:\\Java\\Workspace\\seleniumtraining\\src\\test\\java\\utils\\FB.xlsx";
		sheetName = "Sheet1";
		Object[][] data = getExcelData();
		return data;

	}



	@Test(dataProvider ="LoginData" )
	public static void TestLoginPage(String email, String password) throws InterruptedException {

		SearchPageObjects object = new SearchPageObjects(driver);
		driver.get("https://www.facebook.com/");
		object.loginTest(email, password);
		Thread.sleep(3000);
		System.out.println(email+ "\\" +password);
	}

	public Object[][] getExcelData() throws Exception {

		ExcelUtils excelObject = new ExcelUtils(workbookPath, sheetName);
		int rowCount = excelObject.getRowCount();
		int colCount = excelObject.getColCount();
		Object[][] excelValue = new Object[rowCount][colCount];
		for (int i=0; i<rowCount; i++)
		{
			for (int j=0; j<colCount;j++)
			{
				String  data = excelObject.getCellData(i, j);
				excelValue[i][j] = data;
			}
		}
		return excelValue;
	}
}