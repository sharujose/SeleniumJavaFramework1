package test;
import org.testng.annotations.*;

import pages.HomePageObject;
import pages.LoginPageObject;

public class LoginTestCRM extends TestBaseCRM {
	
	LoginPageObject loginpageObj;
	HomePageObject homePageObject;
	public LoginTestCRM() 
	{
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		
		initializewebPage();
		loginpageObj = new LoginPageObject();
	}
	
	
	@Test()
	public void logintest() {
		homePageObject=loginpageObj.loginTest(prop.getProperty("useremail"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
