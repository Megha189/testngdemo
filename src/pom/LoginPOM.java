package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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
	public void verifyerrormsgColor(WebDriver driver)
	{
		String acolor = errMSG.getCssValue("Color");
		String hexcolor = Color.fromString(acolor).asHex();
		Reporter.log("actual hex color:"+hexcolor,true);
		if(hexcolor.equals("#a94442"))
		{
			Reporter.log("pass:color is matchhing...",true);
		}
		else
		{
			Reporter.log("Fail:color is not matching....",true);
			Assert.fail();
		}
	}
	public void verifyfont()
	{
		
		String afont = errMSG.getCssValue("font-family");
		Reporter.log("font:"+afont,true);
		if(afont.equals("Helvetica, sans-serif, Arial"))
		{
			Reporter.log("Pass:font matcinng...",true);
		}
		else
		{
			Reporter.log("Fail:font matching fail...",true);
		}
	}
}
