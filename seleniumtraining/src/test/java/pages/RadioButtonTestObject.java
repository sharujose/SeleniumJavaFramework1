package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTestObject {
	
	static WebDriver driver;
	
	public RadioButtonTestObject( WebDriver driver )
	{
		this.driver=driver;
	}


	public  void testRadioButton(String radioValue) 
	{

		
		
		List<WebElement> radioElements = driver.findElements(By.xpath("//input[@type='radio' ]"));
	
		for (int i =0;i<radioElements.size();i++)
		{
			String radioText = radioElements.get(i).getAttribute("value");
			System.out.println(radioText);

			if (radioText.equalsIgnoreCase(radioValue))
			{
				
				radioElements.get(i).click();
				
			}
			
			
		}
	}


}
