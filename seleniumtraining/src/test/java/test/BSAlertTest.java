package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BSAlertTest {

	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
	}
	
	@Test(priority =1)
	public void alertTest() {
		driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']")).click();
		
		String text1 =driver.findElement(By.xpath("//div[@class='alert alert-success alert-autocloseable-success']")).getText();
		System.out.println(text1);
	}
}
