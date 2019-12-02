package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");

		driver.findElement(By.name("email")).sendKeys("sharukutty@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test9038");

		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		Thread.sleep(3000);


		//WebElement checkbox=driver.findElement(By.xpath("//td[contains(text(),'ambika pillai')]"));
		
		
		WebElement checkbox= driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']/tbody/tr/td[text()='ambika pillai']/../td[1]//input[@name='id']"));
		checkbox.click();
	}

	


}
