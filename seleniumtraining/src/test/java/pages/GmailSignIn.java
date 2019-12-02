package pages;


import org.openqa.selenium.By;

import test.TestBaseGmail;

public class GmailSignIn extends TestBaseGmail {

	// input[@id='identifierId']
	// span[contains(text(),'Next')]
	// input[@name='password']
	// div[@id='profileIdentifier']
	// span[@class='jibhHc']

	private By email = By.id("identifierId");

	private By nextButton = By.xpath("//span[contains(text(),'Next')]");
	By password = By.xpath("//input[@name='password']");
	By UserAccountText = By.id("profileIdentifier");
	By errorTextEmail = By.xpath("//div[@class='o6cuMc']");

	public String enterEmail(String emailid) throws InterruptedException {
		driver.findElement(email).sendKeys(emailid);
		enterNextButton();
		try {
			waitForElement(UserAccountText);
			String identifierText = driver.findElement(UserAccountText).getText();
			System.out.println(identifierText);
			return identifierText;
		} catch (Exception e) {
			String errortext = driver.findElement(errorTextEmail).getText();
			System.out.println(errortext);
			return errortext;

		}

	}

	public void enterPassword(String pass) {
		waitForElement(password);
		driver.findElement(password).sendKeys(pass);
		enterNextButton();
	}

	public void enterNextButton() {
		driver.findElement(nextButton).click();
	}
}
