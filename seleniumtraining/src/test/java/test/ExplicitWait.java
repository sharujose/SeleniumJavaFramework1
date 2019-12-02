package test;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExplicitWait {

	WebDriver driver;

	@BeforeTest()
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}

	@Test()
	public void testWait() 
	{
		isAlertPresent();
		WebElement searchItem=driver.findElement(By.xpath("//input[contains(@placeholder , 'Search')]"));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(searchItem)).sendKeys("sharu");
		
		
	}
	
	public boolean isAlertPresent() {

	    boolean presentFlag = false;

	    try {

	        // Check the presence of alert
	        Alert alert = driver.switchTo().alert();
	        // Alert present; set the flag
	        presentFlag = true;
	        // if present consume the alert
	        alert.dismiss();
	        //( Now, click on ok or cancel button )

	    } catch (NoAlertPresentException ex) {
	        // Alert not present
	        ex.printStackTrace();
	    }

	    return presentFlag;
	}
}


