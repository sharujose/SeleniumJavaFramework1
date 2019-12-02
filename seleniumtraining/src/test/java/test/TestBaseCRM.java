package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseCRM {
	
	Properties prop;
	public static WebDriver driver;
	
	 public TestBaseCRM() {
		 
		 
		 try {
			 prop = new Properties();
			 FileInputStream ip = new FileInputStream("A:\\Java\\Workspace\\seleniumtraining\\src\\test\\java\\properties\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 public void initializewebPage() {
		 WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(120 ,TimeUnit.SECONDS);
		 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("URL"));
		 
		 
	 }
	 
		public void presenceOfElementLocated(By locator) {

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}

		public WebElement getElement(By locator) {

			WebElement ele = driver.findElement(locator);
			return ele;

		}

		public List<WebElement> getElements(By locator) {

			List<WebElement> ele = driver.findElements(locator);
			return ele;

		}
	
}

