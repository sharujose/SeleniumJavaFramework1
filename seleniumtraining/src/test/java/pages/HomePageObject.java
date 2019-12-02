package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.TestBaseCRM;

public class HomePageObject extends TestBaseCRM{

	@FindBy(xpath="//span[contains(text(),'Sharu Simson')]")
	WebElement usernameLogo;


	@FindBy(xpath="//div[contains(text(),'Deals Summary')]")
	WebElement dealSummaryText;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactlink;

	public HomePageObject() 
	{
		PageFactory.initElements(driver, this);
	}


	public boolean testUsernameLogo()
	{

		return usernameLogo.isDisplayed();
	}


	public boolean testDealSummaryText()
	{

		return dealSummaryText.isDisplayed();
	}
	public String testTitle() {

		return driver.getTitle();
	}

	public ContactPageObject clickContactLink() {
		
		contactlink.click();
		return new ContactPageObject();
	}

}

