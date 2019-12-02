package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.TestBaseCRM;

public class ContactPageObject extends TestBaseCRM
{



	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContact;

	@FindBy(xpath="//div[@name='channel_type']")
	WebElement socialChannelButton;


	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;

	public ContactPageObject() 
	{

		PageFactory.initElements(driver, this);
	}

	public boolean addNewContact() 
	{
		newContact.click();

		return saveButton.isDisplayed();

	}


	public boolean selectSocialChannel()
	{



		newContact.click();
		socialChannelButton.click();

		int i;
		List<WebElement> ddListSC = driver.findElements(By.xpath("//div[@class='visible menu transition']//div[@role ='option']//span[@class='text']"));
		int size = ddListSC.size();
		for(  i=0; i<size;i++)
		{
			String socialChannelName = ddListSC.get(i).getText();


			if (socialChannelName.contains("Facebook"))
			{
				ddListSC.get(i).click();
				break;

			}


		}
		boolean b = ddListSC.get(i).isEnabled();
		return b;
	}

	

}
