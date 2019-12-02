package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.TestBaseCRM;

public class IdeaTestHomePage extends TestBaseCRM { 

	By  serviceTypeNavItems = By.xpath("//nav[@class='mdl-navigation navbar-idea left-nav']//li//a");
	By  serviceNav = By.xpath("//ul[@class='mdl-navigation subNav_links']//a");
	By  selectItemnav = By.xpath("//li[@class='tab-header-and-content']//a");
	By typeBasedServices = By.xpath("//ul[@class='mdl-navigation subNav_links']//span[@class='subNav_links_label']");
	By locationBox = By.id("selectLocation_popup");
	By locationProceedbutton = By.xpath("//a[@title='Proceed']");
	By offerCost =By.xpath("//div[@class='slick-track']//div[@role='option']//span[@class='card_OfferJ_Plan_Cost' ][1]");
	By offerPeriod = By.xpath("//div[@class='slick-track']//div[@role='option']//p[@class='card_OfferJ_Plan_Validity' ][1]");
	By headerText = By.xpath("//div[@class='card_OfferJ_Header']//p[@class='packName'][1]");
	By buttonPalnSelect = By.xpath("//div[@amount='399']//descendant::a[2]");
	//By buttonPalnSelect = By.xpath("//div[@amount='399']//child::p[contains(text(),'70')]//following::a[@class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect buynow NCB_buynow'][1]");
	
	public void selectServiceType(String value) throws InterruptedException 
	{
		WebDriverWait wait= new WebDriverWait(driver,60);
		WebElement dialog =wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wzrk-cancel")));
		dialog.click();
		WebDriverWait wait2= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(serviceTypeNavItems));
		List<WebElement> serviceTypeItems =driver.findElements(serviceTypeNavItems);
		for(int i=0;i<serviceTypeItems.size();i++)
		{
			if(serviceTypeItems.get(i).getAttribute("innerHTML").contains(value))
			{
				serviceTypeItems.get(i).click();
				break;
			}
		}
		
	}
	
	public void addOnSelection(String amount,String serviceType)
	{
		//driver.switchTo().frame(1);
		WebDriverWait wait3= new WebDriverWait(driver,90);
		wait3.until(ExpectedConditions.presenceOfElementLocated(typeBasedServices));
		List<WebElement> typeofService=driver.findElements(typeBasedServices);
		for(int i=0;i<typeofService.size();i++)
		{
			if(typeofService.get(i).getAttribute("innerHTML").equalsIgnoreCase(serviceType))
					
			{
				typeofService.get(i).click();
				break;
			}
		}
		
		
		
		presenceOfElementLocated(locationBox);
		Select selectDropDown = new Select(driver.findElement(locationBox));
		selectDropDown.selectByVisibleText("Kerala");
		
		presenceOfElementLocated(locationProceedbutton);
		driver.findElement(locationProceedbutton).click();
		
		//WebDriverWait wait6= new WebDriverWait(driver,90);
		//wait6.until(ExpectedConditions.visibilityOfElementLocated(offerCost));
		//System.out.println(driver.findElement(offerCost).getText());
		
		By buttonPalnSelect = By.xpath("//div[@amount="+amount+"]//descendant::a[2]");
		presenceOfElementLocated(buttonPalnSelect);
		//System.out.println(driver.findElement(offerCost).getText());;  
		driver.findElement(buttonPalnSelect).click();
		
	}

}
