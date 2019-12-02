package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlertTest {


	WebDriver driver;

	@BeforeMethod
	public void setUp() {


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	}
	
	@Test(priority =3)
	public void alertTest() {
		
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); 
		alert.accept();
		
	}
	
	@Test(priority =2)
	public void alertTest2() {
		
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); 
		alert.dismiss();
		
	}
	
	@Test(priority =1)
	public void alertTest3() {
		
		
		
		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); 
		alert.sendKeys("Sharu");
		alert.accept();
		
	}
	
	

}
