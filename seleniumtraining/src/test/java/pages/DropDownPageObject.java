package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPageObject {

	public static void main(String[] args) {
		setupTest();
		//testLogin();
		testRadioButton();
		//close();
	}
	
	
	static WebDriver driver;

	static By dropDownButton = By.id("dropdownMenu");
	
	public static void setupTest() {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	/*public static void testLogin() {
		driver.get("https://coreui.io/docs/components/dropdowns/#");
	driver.findElement(dropDownButton).click();
		List<WebElement> dd_list = driver.findElements(By.xpath("//div[@class='dropdown-menu show' and @aria-labelledby='dropdownMenu']//a"));
	for ( int i = 0 ; i <dd_list.size();i++) {
	
		WebElement element =dd_list.get(i);
		String values =element.getText();
		
			System.out.println(values);
		}

	
	}*/
	
	
	public static void testRadioButton() {
		
		driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
		driver.manage().window().maximize();
		List<WebElement> radioElements = driver.findElements(By.xpath("//input[@type='radio' ]"));
		
		for (int i =0;i<radioElements.size();i++)
		{
			String radioText = radioElements.get(i).getAttribute("value");
			System.out.println(radioText);
			
			if (radioText.equalsIgnoreCase("female"))
			{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				radioElements.get(i).click();
			}
		}
	}
	
	
	
	/*public static void close() {
		
		driver.quit();
	}*/
}
