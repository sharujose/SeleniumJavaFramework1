package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;

public class ConatcPageTestCRM extends TestBaseCRM {

	LoginPageObject loginpageObj;
	HomePageObject homePageObject;
	ContactPageObject contactPageObject;


	public ConatcPageTestCRM() 
	{
		super();
	}

	@BeforeMethod()
	public void setup()
	{
	initializewebPage();
	loginpageObj = new LoginPageObject();
	homePageObject = loginpageObj.loginTest(prop.getProperty("useremail"), prop.getProperty("password"));
	contactPageObject = homePageObject.clickContactLink();
	}
	
	@Test(priority = 2)
	public void addNewContact() 
	{
		//homePageObject.testUsernameLogo();
		
		//contactPageObject.addNewContact();
		Assert.assertTrue(contactPageObject.addNewContact());
		
	}
	
	@Test(priority = 1)
	public void testselectSocialChannel() 
	{
		//homePageObject.testUsernameLogo();
		Assert.assertTrue(contactPageObject.selectSocialChannel());
		
	}
	

	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}
