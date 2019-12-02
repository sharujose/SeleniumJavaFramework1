package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.GmailSignIn;
import pages.ListenerClass;
@Listeners(ListenerClass.class)
public class GmailSigninTest extends TestBaseGmail{
	
	GmailSignIn GmailSignInObject = new GmailSignIn();
	
	@BeforeMethod()
	public void setup()
	{
		initialize();
	}
	
	@Test()
	public void addEmailId() throws InterruptedException
	{
		String text = GmailSignInObject.enterEmail("sharuimson");
		Assert.assertEquals(text, "sharusimson@gmail.com");
		
		//GmailSignInObject.enterPassword("sharusimson");
		//Assert.assertEquals(text, "sharusimson@gmail.com");
	}
	
	
		
		
	

}
