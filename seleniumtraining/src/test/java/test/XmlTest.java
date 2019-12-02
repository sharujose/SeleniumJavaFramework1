package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
public class XmlTest {
	
	WebDriver driver;
	
	@BeforeMethod

	public void setUp() {
		
	    
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://secure.yatra.com/social/common/yatra/register");
		
	}

	
	
	@Test(priority =1, groups = {"female"})
	@Parameters("searchname1")
	public void testlogin1(String searchname) throws IOException
	{
		driver.findElement(By.id("login-input")).clear();
		driver.findElement(By.id("login-input")).sendKeys(searchname);
		driver.findElement(By.id("login-continue-btn")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("A:\\Java\\Workspace\\seleniumtraining\\src\\test\\java\\test\\XmlTest.jpg"));
	}
	@Test(priority =2,groups = {"male"})
	@Parameters("searchname2" )
	public void testlogin2(String searchname)
	{
		driver.findElement(By.id("login-input")).clear();
		driver.findElement(By.id("login-input")).sendKeys(searchname);
		driver.findElement(By.id("login-continue-btn")).click();
	}
	
	@Test(priority =3 ,groups = {"male2"})
	@Parameters("searchname3")
	public void testlogin3(String searchname)
	{
		driver.findElement(By.id("login-input")).clear();
		driver.findElement(By.id("login-input")).sendKeys(searchname);
		driver.findElement(By.id("login-continue-btn")).click();
	}
	
	@Test(priority =4 ,groups = {"female"})
	@Parameters("searchname4")
	public void testlogin4(String searchname)
	{
		driver.findElement(By.id("login-input")).clear();
		driver.findElement(By.id("login-input")).sendKeys(searchname);
		driver.findElement(By.id("login-continue-btn")).click();
	}
	
	

	@Test(dependsOnMethods ="testlogin4",priority =5 ,groups = {"test"})
	
	public void testlogin5()
	{
		System.out.println("checking");
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
