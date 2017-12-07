package executor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public static Logger log=Logger.getLogger("BaseTest");
	public WebDriver driver;
	static
	{
		log.info("setting the path..");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	@BeforeMethod(alwaysRun=true)
	public void openApplication()
	{
		driver = new ChromeDriver();
		driver.get("http://localhost/app/admin/");
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp()
	{
		driver.close();
	}
}
