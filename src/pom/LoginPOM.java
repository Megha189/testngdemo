package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPOM {
	
	@FindBy(name="username")
	private WebElement unTB;
	@FindBy(name="password")
	private WebElement pwTB;
	@FindBy(xpath="//button[.='Login']")
	private WebElement loginBTN; 
	@FindBy(xpath="//div[contains(text(),'information')]")
	private WebElement errMSG;
	public LoginPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUnTB(String un) {
		unTB.sendKeys(un);;
	}
	
	public void setPwTB(String pw) {
		pwTB.sendKeys(pw);
	}
	public void clickLogin()
	{
		loginBTN.click();
	}
	public void verifyerrormsg(WebDriver driver)
	{
		String errText=errMSG.getText();
		Reporter.log("errtext:"+errText);
		if(errMSG.isDisplayed())
		{
			Reporter.log("pass:error is dipalyed..",true);
		}
		else
		{
			Reporter.log("Fail:Error message is not dispalyed..",true);
			Assert.fail();
		}
	}

}
