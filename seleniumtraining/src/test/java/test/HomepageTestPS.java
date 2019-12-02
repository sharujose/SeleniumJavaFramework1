
package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomepageObjectPracticeSite;

public class HomepageTestPS extends TestBaseCRM{

	//WebDriver driver;
	HomepageObjectPracticeSite homepageObject ;
	//HomepageObject homepageObject = new HomepageObject();
	public HomepageTestPS() {super();}


	@BeforeMethod
	public  void setup() {

		initializewebPage();
		homepageObject = new HomepageObjectPracticeSite();


	}



	@Test(priority=1,enabled=false)
	public void checkArrivalCount() throws InterruptedException 
	{
		//System.out.println(homepageObject.getArrivalCount());
		//List<WebElement> arrivalList =driver.findElements(By.xpath("//ul[@class='products']"));
		//int x =arrivalList.size();
		//System.out.println(x);

		int actualvalue =homepageObject.getArrivalCount();
		System.out.println(actualvalue);
		Assert.assertEquals(actualvalue, 3);
	}

	@Test(enabled=false)
	public void addtoCartCheck() throws InterruptedException
	{

		homepageObject.checkNavigation();
	}


@Test(enabled=false)
public void stockCountCheckExcess() {
	
	
	Assert.assertEquals(homepageObject.checkinvalidStockCount(), false);
	
}


@Test(enabled=false)
public void stockCountCheck() {
	
	
	Assert.assertEquals(homepageObject.checkStockCount(), true);
}


@Test(priority =1 ,enabled=false)
public void checkoutTest() {
	
	Assert.assertEquals(homepageObject.checkout(), true);
}

@Test(priority =1 ,enabled=false)
public void checkoutTestwithCoupon() {
	
	Assert.assertEquals(homepageObject.checkoutwithCoupon(), true);
}

@Test(priority =1 ,enabled=false)
public void checkCouponAmount() {
	
	Assert.assertEquals(homepageObject.checkCouponAmount(), false);
}

@Test(priority =1 ,enabled=true)
public void removeProducts() throws InterruptedException {
	
	Assert.assertEquals(homepageObject.removeProducts(), true);
}


	@AfterMethod()
	public void close()
	{
		driver.close();
	}


}
