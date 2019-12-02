package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTest {

	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

	}
	

	@Test
	public void tableTest() throws InterruptedException 
	{
		
		List<WebElement> Rows = driver.findElements(By.xpath("//table[@id='task-table']//tr"));
		int rowCount= Rows.size();
		
		for(int i =1;i<rowCount;i++)
		{
			//driver.switchTo().frame(0);
			String ColValue =driver.findElement(By.xpath("//table[@id='task-table']//tr["+i+"]//td[4]")).getText();
			if(ColValue.contentEquals("in progress"	))
			{
				String Assgnname=driver.findElement(By.xpath("//table[@id='task-table']//tr["+i+"]//td[3]")).getText();
				System.out.println(Assgnname);
			}
		}
				
		
	}
}
