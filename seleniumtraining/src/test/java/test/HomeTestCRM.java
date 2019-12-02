package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;

public class HomeTestCRM extends TestBaseCRM  {

	LoginPageObject loginpageObj;
	HomePageObject homePageObject;
	ContactPageObject contactPageObject;

	public HomeTestCRM() 
	{
		super();
	}

	@BeforeMethod()
	public void setup()
	{
		initializewebPage();
		loginpageObj = new LoginPageObject();
		homePageObject = loginpageObj.loginTest(prop.getProperty("useremail"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void testUserNameValue() 
	{
		//homePageObject.testUsernameLogo();
		Assert.assertTrue(homePageObject.testUsernameLogo());
		
	}
	@Test(priority = 2)
	public void testDealSummaryText() 
	{
		//homePageObject.testUsernameLogo();
		Assert.assertTrue(homePageObject.testDealSummaryText());
		
	}
	
	@Test(priority=3)
	public void TestTitle() 
	{
		
		String title = (homePageObject.testTitle());
		Assert.assertEquals(title, "CRM", "Correct title found");
		
	}

	
	@Test(priority=4)
	public void TestContactPageClick() 
	{
		
		
		contactPageObject = homePageObject.clickContactLink();
		
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}
