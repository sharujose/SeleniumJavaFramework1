package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.TestBaseCRM;

public class HomepageObjectPracticeSite extends TestBaseCRM {

	

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeButton;

	@FindBy(id = "menu-item-40")
	WebElement shopButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addtoCartButton;

	By shoppingcart = By.xpath("//span[@class='amount']");

	By couponbox = By.id("coupon_code");
	By CouponButton = By.name("apply_coupon");

	By couponElement = By.xpath("//th[contains(text(),'Coupon: krishnasakinala')]");
	By subTotal = By.xpath("//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']");
	By CheckoutButton = By.xpath("//a[contains(text(),'Proceed to Checkout')]");

	By menuShopButton = By.xpath("//a[contains(text(),'Shop')]");
	By item180 = By.xpath("//span[@class='woocommerce-Price-amount amount']");

	By cartGridPrice = By.xpath("//*[@class='shop_table shop_table_responsive cart']//tr//td[4]");

	public HomepageObjectPracticeSite() {
	PageFactory.initElements(driver, this);
	}

	public int getArrivalCount() throws InterruptedException {

		WebDriverWait shopButtonwait = new WebDriverWait(driver, 50);
		shopButtonwait.until(ExpectedConditions.elementToBeClickable(shopButton)).click();

		WebDriverWait homeButtonwait = new WebDriverWait(driver, 50);
		homeButtonwait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();

		// Thread.sleep(5000);
		/*
		 * shopButton.click(); homeButton.click();
		 */
		// driver.findElement(By.id("menu-item-40")).click();

		List<WebElement> arrivalList = driver.findElements(By.xpath("//ul[@class='products']"));
		int x = arrivalList.size();
		return x;

	}

	public int checkNavigation() throws InterruptedException {
		List<WebElement> arrivalList = driver.findElements(By.xpath("//ul[@class='products']"));
		int x = arrivalList.size();
		for (int i = 0; i < x; i++) {
			boolean flag = false;
			List<WebElement> arrivalList2 = driver.findElements(By.xpath("//ul[@class='products']"));

			WebDriverWait arrivalListwait = new WebDriverWait(driver, 50);
			arrivalListwait.until(ExpectedConditions.visibilityOfAllElements(arrivalList2));

			arrivalList2.get(i).click();

			try {

				WebElement out = driver.findElement(By.xpath("//p[contains(text(),'Out of stock')]"));
				WebDriverWait addtoCartwait = new WebDriverWait(driver, 10);
				addtoCartwait.until(ExpectedConditions.visibilityOf(out));
				String produtName = driver.findElement(By.xpath("//div[contains(@class,'summary entry-summary')]//h1"))
						.getAttribute("innerHTML");
				System.out.println("out of stock  : " + produtName);
				homeButton.click();
				continue;
			} catch (Exception e) {

				// TODO Auto-generated catch block
				flag = true;

				e.printStackTrace();
			}
			// if(flag==false) {
			// driver.findElement(By.xpath("//p[@class='stock out-of-stock']")).click();
			WebDriverWait addtoCartwait = new WebDriverWait(driver, 30);
			addtoCartwait.until(ExpectedConditions.visibilityOf(addtoCartButton)).click();
			String bookName = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
			System.out.println(bookName);
			WebDriverWait homeButtonwait = new WebDriverWait(driver, 50);
			homeButtonwait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
			// }

		}
		return 1;
	}

	public boolean checkinvalidStockCount() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@title='Selenium Ruby']"))).click();
		;
		String stockvalue = driver.findElement(By.xpath("//p[@class='stock in-stock']")).getAttribute("innerHTML")
				.split(" ")[0];
		// String count = stockvalue[0];
		int count1 = Integer.parseInt(stockvalue) + 3;
		System.out.println(count1);
		// String maxcount = Integer.toString(count1);
		driver.findElement(By.name("quantity")).clear();
		// driver.findElement(By.name("quantity")).click();
		driver.findElement(By.name("quantity")).sendKeys(String.valueOf(count1));

		WebDriverWait addtoCartwait = new WebDriverWait(driver, 30);
		addtoCartwait.until(ExpectedConditions.visibilityOf(addtoCartButton)).click();
		boolean flag;

		try {
			WebElement basketButton = driver.findElement(By.xpath("//a[contains(text(),'View Basket')]"));
			WebDriverWait homeButtonwait = new WebDriverWait(driver, 50);
			homeButtonwait.until(ExpectedConditions.visibilityOf(basketButton));
			System.out.println("product  added to cart");
			flag = true;
		} catch (Exception e) {
			System.out.println("product not added to cart");
			flag = false;
		}

		return flag;
	}

	public boolean checkStockCount() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@title='Selenium Ruby']"))).click();
		;
		String stockvalue = driver.findElement(By.xpath("//p[@class='stock in-stock']")).getAttribute("innerHTML")
				.split(" ")[0];
		System.out.println(stockvalue);
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys(stockvalue);

		WebDriverWait addtoCartwait = new WebDriverWait(driver, 30);
		addtoCartwait.until(ExpectedConditions.visibilityOf(addtoCartButton)).click();

		boolean flag;
		try {
			WebElement basketButton = driver.findElement(By.xpath("//a[contains(text(),'View Basket')]"));
			WebDriverWait homeButtonwait = new WebDriverWait(driver, 50);
			homeButtonwait.until(ExpectedConditions.visibilityOf(basketButton));
			System.out.println("product  added to cart");
			flag = true;
		} catch (Exception e) {
			System.out.println("product not added to cart");

			flag = false;

		}

		return flag;
	}

	public boolean checkout() {
		checkStockCount();
		presenceOfElementLocated(shoppingcart);
		driver.findElement(shoppingcart).click();
		presenceOfElementLocated(CheckoutButton);
		driver.findElement(CheckoutButton).click();

		return true;
	}

	public boolean checkoutwithCoupon() {
		checkStockCount();
		presenceOfElementLocated(shoppingcart);
		driver.findElement(shoppingcart).click();
		presenceOfElementLocated(couponbox);
		driver.findElement(couponbox).sendKeys("krishnasakinala");
		presenceOfElementLocated(CouponButton);
		driver.findElement(CouponButton).click();

		boolean flag;
		try {
			presenceOfElementLocated(couponElement);
			String couponText = driver.findElement(couponElement).getAttribute("innerHTML");
			System.out.println(couponText + "added successfully");
			flag = true;
		} catch (Exception e) {
			System.out.println("coupon not added");
			flag = false;
		}
		presenceOfElementLocated(CheckoutButton);
		getElement(CheckoutButton).click();
		return flag;
	}

	public boolean checkCouponAmount() {
		presenceOfElementLocated(menuShopButton);
		getElement(menuShopButton).click();
		presenceOfElementLocated(item180);
		int size = driver.findElements(item180).size();
		for (int i = 0; i < size; i++) {
			if (getElements(item180).get(i).getAttribute("innerHTML").contains("180")) {
				getElements(item180).get(i).click();
				break;
			}

		}

		WebDriverWait addtoCartwait = new WebDriverWait(driver, 30);
		addtoCartwait.until(ExpectedConditions.visibilityOf(addtoCartButton)).click();

		presenceOfElementLocated(shoppingcart);
		driver.findElement(shoppingcart).click();
		presenceOfElementLocated(couponbox);
		driver.findElement(couponbox).sendKeys("krishnasakinala");
		presenceOfElementLocated(CouponButton);
		driver.findElement(CouponButton).click();

		boolean flag;
		try {
			presenceOfElementLocated(couponElement);
			String couponText = driver.findElement(couponElement).getAttribute("innerHTML");
			System.out.println(couponText + "added successfully");
			flag = true;
		} catch (Exception e) {
			System.out.println("coupon not added");
			String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();
			System.out.println(errorMessage);
			flag = false;
		}

		return flag;
	}

	public boolean removeProducts() throws InterruptedException {

		presenceOfElementLocated(menuShopButton);
		getElement(menuShopButton).click();
		presenceOfElementLocated(item180);
		int size = driver.findElements(item180).size();
		for (int i = 0; i < size; i++) {
			if (getElements(item180).get(i).getAttribute("innerHTML").contains("180")
					|| getElements(item180).get(i).getAttribute("innerHTML").contains("150")) {
				getElements(item180).get(i).click();
				WebDriverWait addtoCartwait = new WebDriverWait(driver, 30);
				addtoCartwait.until(ExpectedConditions.visibilityOf(addtoCartButton)).click();
				getElement(menuShopButton).click();

			}

		}

		presenceOfElementLocated(shoppingcart);
		driver.findElement(shoppingcart).click();
		presenceOfElementLocated(cartGridPrice);
		int noOfProducts = getElements(cartGridPrice).size();
		for (int j = 0; j < noOfProducts; j++)

		{
			String content = getElements(cartGridPrice).get(j).getText();
			if (content.contains("150")) {
				
				driver.findElement(
						By.xpath("//*[@class='shop_table shop_table_responsive cart']//tr[" + (j + 1) + "]//td[1]//a"))
						.click();
				

			}
		}

		boolean flag = true;
		return flag;
	}


}
