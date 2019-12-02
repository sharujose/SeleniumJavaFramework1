package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;

public class CheckBoxTestObject {

	static WebDriver driver;

	public CheckBoxTestObject(WebDriver driver)
	{
		this.driver = driver;

	}
	
	public static void testCheckBox(String value) {

		
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox' and @name='tool']"));
		
		for ( int i = 0 ; i<checkBoxList.size();i++)
		{
			String checkBoxText = checkBoxList.get(i).getAttribute("value");
			System.out.println(checkBoxText);
			if(checkBoxText.equalsIgnoreCase(value))
			{
				checkBoxList.get(i).click();
			}
			if (checkBoxList.get(i).isSelected())
			{
              System.out.println("check box selected with value"+checkBoxText);
			}
			
			//Assert.assertEquals(value, checkBoxText);
		}
	}

}
