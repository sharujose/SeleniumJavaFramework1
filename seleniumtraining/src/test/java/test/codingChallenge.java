package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class codingChallenge {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");

	}
	
	@Test
	public void searchProperty() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='search-input-location']")).sendKeys("London");
		driver.findElement(By.id("search-submit")).click();
		WebElement title = driver.findElement(By.xpath("//div//strong[contains(text(),'London property for sale')]"));
		String propName = title.getText();
		System.out.println(propName);
		Assert.assertEquals(propName, "London property for sale");
		Thread.sleep(30000);
		List<WebElement> listProp = driver.findElements(By.xpath("//div[@class='listing-results-right clearfix']//a[@class='listing-results-price text-price']"));
		Collections.sort(listProp,new Comparator<WebElement>(){
			public int compare(WebElement obj1, WebElement obj2) {
				
				return obj1.getText().compareTo(obj2.getText());
			}
		});
		for(int i=0;i<listProp.size();i++) {
			System.out.println(listProp.get(i).getText());
		
		}
		driver.findElement(By.xpath("//ul//li[6]//a[@class='photo-hover']")).click();
		////li[6][contains(@id,'listing_')]//a[@class='photo-hover']
		
		/*//div[contains(text(),'Avon')]//following::td[2]*/
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
