package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObjects {

	static WebDriver driver;
	By emailTextBox = By.id("email");
	By passwordTextBox = By.id("pass");
	By loginButton = By.id("loginbutton");

	public  SearchPageObjects(WebDriver driver) 
	{

		this.driver = driver;


	}
	public void loginTest(String username ,String password) 
	{

		driver.findElement(emailTextBox).sendKeys(username);
		driver.findElement(passwordTextBox).sendKeys(password);
		driver.findElement(loginButton).sendKeys(Keys.RETURN);


	}
}
