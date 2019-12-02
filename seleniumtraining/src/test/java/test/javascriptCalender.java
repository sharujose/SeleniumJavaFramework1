package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptCalender 
{

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		
		WebElement datepicker = driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_view_date1\']"));
		//WebElement datepicker = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		
		
		
		System.out.println(datepicker.getAttribute("value")); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].setAttribute('value','13-11-2020');", datepicker);
		js.executeScript(("arguments[0].value='13-11-2020'"),datepicker);
		
		
		
}
}