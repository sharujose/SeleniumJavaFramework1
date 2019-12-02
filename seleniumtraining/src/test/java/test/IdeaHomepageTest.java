package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.IdeaTestHomePage;

public class IdeaHomepageTest extends TestBaseCRM { 
	
	IdeaTestHomePage homepageObject;
	
	@BeforeMethod
	public void setup(){
		
		initializewebPage();
		homepageObject = new IdeaTestHomePage();
		
	}
	

	@Test(priority=1)
	public  void selectServiceTest() throws InterruptedException
	{
		homepageObject.selectServiceType("Prepaid");
		homepageObject.addOnSelection("399","Packs");
	}
	
	//@Test(priority=2)
	//public  void selectAddOn() throws InterruptedException
	//{
		//homepageObject.addOnSelection();
	//}
	
}
