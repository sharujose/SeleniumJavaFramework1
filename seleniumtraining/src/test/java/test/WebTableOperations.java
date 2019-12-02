package test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableOperations {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Fighter/Documents/testtable.html");
		
		
		List<WebElement> priceList= driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[4]"));
		int[] array = new int[priceList.size()];
		for(int i=0;i<priceList.size();i++)
		
		{
			
			array[i]= Integer.parseInt(priceList.get(i).getText());
		}
		Arrays.sort(array);
		System.out.println(array[array.length-1]);
		//getting all headers
		List<WebElement> headerOfTable = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		//for(WebElement header:allHeadersOfTable1)
		for(int i=0;i<headerOfTable.size();i++)

		{
			System.out.println(headerOfTable.get(i).getText());
		}

		//no of rows

		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));


		System.out.println(noOfRows.size()-1);//without header



		//no of columns in each row


		for (int j=2; j<noOfRows.size();j++) 
		{
			List<WebElement> columnInRow =driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr["+j+"]/td"));
			System.out.println("No of columns in row no "+ (j-1)+ " is "+columnInRow.size());
		}


		//books writtem by author Mukesh


		for (int k=2; k<noOfRows.size();k++)
		{
			WebElement authorcolumn =driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+k+"]/td[2]"));
			if(authorcolumn.getText().contains("Mukesh")) 
			{
				WebElement bookcolumn =driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+k+"]/td[1]"));
				System.out.println(bookcolumn.getText());
			}
		}


//easy method
		List<WebElement> allColumnsInRow=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[text()= 'Mukesh']/../td[1]"));
		for(WebElement e: allColumnsInRow)
		{
			System.out.println(e.getText());
		}




//finding amount
		
		WebElement priceOfBook=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr/td[text()= 'Learn Java']/../td[4]"));
		System.out.println(priceOfBook.getText());
		driver.close();
	}
}
