package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionTest {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.amazon.in/");
		driver.get("http://jqueryui.com/droppable/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		//action.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//div[@id='droppable']"))).release().build().perform();
		//action.moveToElement(driver.findElement(By.xpath("//span[@class='nav-line-1'][contains(text(),'Shop by')]"))).build().perform();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[contains(text(),'Echo & Alexa')]")).click();
		//driver.quit();
		WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		action.dragAndDrop(source, target).build().perform();
		
		
		/***************drag and drop****************/
		
		
		
		
	}
	
	
	
	//li[@id='header-addons']//a[@id='highlight-addons']
}
