package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RadioButtonTestObject;

public class RadioButtonTest {

	static WebDriver driver;
	
	@BeforeTest()
	public static void setupTest() {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	@Test()
	public static void testRadioButton()
	{
	driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
	driver.manage().window().maximize();
	
	driver.manage().deleteAllCookies();
	//Alert alert = driver.switchTo().alert();
	//alert.dismiss();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RadioButtonTestObject testObject = new RadioButtonTestObject(driver);
		try {
			testObject.testRadioButton("female");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
