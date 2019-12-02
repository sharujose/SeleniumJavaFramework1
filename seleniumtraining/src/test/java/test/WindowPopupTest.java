package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopupTest {


	WebDriver driver;

	@BeforeMethod
	public void setUp() {


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
	}
	
	@Test(priority =1)
	public void alertTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]")).click();
		//driver.findElement(By.xpath("//div[@class='input-group date']//input[@type='text']"));
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindowID= it.next();
		String childWindowID= it.next();
		driver.switchTo().window(childWindowID);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentWindowID);

	}

	@Ignore
	@Test(priority =1)
	public void BSCalender() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='input-group date']//input[@type='text']")).sendKeys("28/06/2019");
		driver.findElement(By.xpath("//div[@class='input-group date']//input[@type='text']")).sendKeys(Keys.RETURN);
	}
}


