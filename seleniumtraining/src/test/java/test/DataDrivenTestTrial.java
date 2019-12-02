package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Xls_Reader;

public class DataDrivenTestTrial {


	WebDriver driver;
	By emailTextBox = By.id("firstname");
	By passwordTextBox = By.id("lastname");
	//By loginButton = By.id("loginbutton");
	static Xls_Reader reader;
	@BeforeMethod
	public void setUp() {


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fin.ebay.com%2F");

	}


	@DataProvider()
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> fullData =getDataExcel();
		return fullData.iterator();
	}

	@Test(dataProvider = "getData")
	public void loginTest(String username ,String password) 
	{

		driver.findElement(emailTextBox).sendKeys(username);
		driver.findElement(passwordTextBox).sendKeys(password);
		//driver.findElement(loginButton).sendKeys(Keys.RETURN);


	}


	public static ArrayList<Object[]> getDataExcel(){

		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("A:\\Java\\Workspace\\seleniumtraining\\src\\test\\java\\utils\\FB.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum<reader.getRowCount("sheet3");rowNum++)
		{
			String Fname = reader.getCellData("sheet3", "fname", rowNum);
			String lname = reader.getCellData("sheet3", "lname", rowNum);
			Object ob[] = {Fname,lname};
			myData.add(ob);
		}
		return myData;
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}


}


