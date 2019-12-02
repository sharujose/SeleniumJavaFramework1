package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomTest {
	WebDriver driver;
	@BeforeTest()
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.get("https://emicalculator.net/");
	}
	@Ignore
	@Test(priority=1)
	public void selectCheckBox()
	{

		//List<WebElement> checklist = driver.findElements(By.xpath("//label[text()='Option 2']//input[@class='cb1-element']"));

		//WebDriverWait wait = new WebDriverWait(driver,30);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='cb1-element']"))));


		/*for(int i=0;i<checklist.size();i++)
		{
			String checkBoxText = checklist.get(i).getText();

			if(checkBoxText.contentEquals("Option 3"))
			{
				checklist.get(i).click();

			}
		}*/

	}
	@Ignore
	@Test(priority=2)
	public void checkDifferernt() throws Exception
	{

		String option ="Option 2";
		WebElement checklist = driver.findElement(By.xpath("//label[text()='"+option+"']//input[@class='cb1-element']"));
		checklist.click();
		Assert.assertEquals(checklist.isSelected(), true);

		WebElement clickAll = driver.findElement(By.xpath("//input[@type='button']"));
		clickAll.click();
		Thread.sleep(2000);
		String text=clickAll.getAttribute("value");
		Assert.assertEquals(text, "Uncheck All");
	}


	@Ignore
	@Test(priority=1)
	private void alertCheck() 
	{

		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert= driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority=1, enabled=false)

	private void windowPopUp() {

		driver.findElement(By.xpath("//a[contains(text(),'On Twitter')]")).click();
		Set<String> windowvalues = driver.getWindowHandles();
		Iterator<String> itr =windowvalues.iterator();
		String parentWindow =itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.close();
	}
	
	
	@Test
	private void emi() 
	{
     
		WebElement slider=driver.findElement(By.xpath("//div[@id='loaninterestslider']//span[contains(@class,'ui-slider-handle ui-state-default ui-corner-all')]"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(slider));
		Actions action= new Actions(driver);
		action.dragAndDropBy(slider, 100, 0).release().build().perform();
	}
}
