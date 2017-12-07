package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CustomerPOM {
	public CustomerPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void verifyTitle(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		try
		{
			wait.until(ExpectedConditions.titleIs("Dashboard"));
			Reporter.log("title name matching...Dashboard="+driver.getTitle(),true);
		}
		catch(Exception e)
		{
			Reporter.log("title is not matching....");
			
		}
		
	}
}
