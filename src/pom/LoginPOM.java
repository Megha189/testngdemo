package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	
	@FindBy(name="username")
	private WebElement unTB;
	@FindBy(name="password")
	private WebElement pwTB;
	@FindBy(xpath="//button[.='Login']")
	private WebElement loginBTN; 
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

}
