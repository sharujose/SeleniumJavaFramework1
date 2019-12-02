package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.TestBaseCRM;

public class LoginPageObject extends TestBaseCRM {
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	public LoginPageObject()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePageObject loginTest(String uname, String pwd) 
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePageObject();
		
		
		
	}
	

}
