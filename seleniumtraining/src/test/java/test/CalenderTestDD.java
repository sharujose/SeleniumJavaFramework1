package test;






import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTestDD  {

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
		driver.get("https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html");
		driver.findElement(By.id("datepicker")).click();
		WebElement ddMonth = driver.findElement(By.className("ui-datepicker-month"));
		Select selectMonth = new Select(ddMonth);
		selectMonth.selectByVisibleText("Feb");
		
		WebElement ddYear = driver.findElement(By.className("ui-datepicker-year"));
		Select selectyear= new Select(ddYear);
		selectyear.selectByVisibleText("2018");
		String date ="24";
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()="+date+"]")).click();;
		//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()='14']
		Thread.sleep(2000);
		System.out.println(	driver.findElement(By.id("datepicker")).getAttribute("value"));
		
	}
}